/*
 * ============================================================================
 * GNU Lesser General Public License
 * ============================================================================
 *
 * JasperReports - Free Java report-generating library.
 * Copyright (C) 2001-2006 JasperSoft Corporation http://www.jaspersoft.com
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307, USA.
 * 
 * JasperSoft Corporation
 * 303 Second Street, Suite 450 North
 * San Francisco, CA 94107
 * http://www.jaspersoft.com
 */

/*
 * Contributors:
 * Mirko Wawrowsky - mawawrosky@users.sourceforge.net
 */
package net.sf.jasperreports.engine.export;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import java.util.StringTokenizer;

import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRPrintElement;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JRPrintText;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.util.JRStyledText;
import net.sf.jasperreports.engine.util.JRStyledTextParser;

import org.xml.sax.SAXException;


/**
 * Exports a JasperReports document to CSV format. It has character output type and exports the document to a
 * grid-based layout.
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: JRCsvExporter.java 1229 2006-04-19 13:27:35 +0300 (Wed, 19 Apr 2006) teodord $
 */
public class JRCsvExporter extends JRAbstractExporter
{


	/**
	 *
	 */
	protected JRStyledTextParser styledTextParser = new JRStyledTextParser();

	/**
	 *
	 */
	protected String delimiter = null;	

	/**
	 *
	 */
	protected String recordDelimiter = null;	

	/**
	 *
	 */
	protected Writer writer = null;
	protected JRExportProgressMonitor progressMonitor = null;

	
	/**
	 *
	 */
	public void exportReport() throws JRException
	{
		progressMonitor = (JRExportProgressMonitor)parameters.get(JRExporterParameter.PROGRESS_MONITOR);
		
		/*   */
		setOffset();

		/*   */
		setInput();

		/*   */
		if (!isModeBatch)
		{
			setPageRange();
		}

		String encoding = (String)parameters.get(JRExporterParameter.CHARACTER_ENCODING);
		if (encoding == null)
		{
			encoding = "ISO-8859-1";
		}
		
		delimiter = (String)parameters.get(JRCsvExporterParameter.FIELD_DELIMITER);
		if (delimiter == null)
		{
			delimiter = ",";
		}
		
		recordDelimiter = (String)parameters.get(JRCsvExporterParameter.RECORD_DELIMITER);
		if (recordDelimiter == null)
		{
			recordDelimiter = "\n";
		}		
		
		StringBuffer sb = (StringBuffer)parameters.get(JRExporterParameter.OUTPUT_STRING_BUFFER);
		if (sb != null)
		{
			try
			{
				writer = new StringWriter();
				exportReportToWriter();
				sb.append(writer.toString());
			}
			catch (IOException e)
			{
				throw new JRException("Error writing to StringBuffer writer : " + jasperPrint.getName(), e);
			}
			finally
			{
				if (writer != null)
				{
					try
					{
						writer.close();
					}
					catch(IOException e)
					{
					}
				}
			}
		}
		else
		{
			writer = (Writer)parameters.get(JRExporterParameter.OUTPUT_WRITER);
			if (writer != null)
			{
				try
				{
					exportReportToWriter();
				}
				catch (IOException e)
				{
					throw new JRException("Error writing to writer : " + jasperPrint.getName(), e);
				}
			}
			else
			{
				OutputStream os = (OutputStream)parameters.get(JRExporterParameter.OUTPUT_STREAM);
				if (os != null)
				{
					try
					{
						writer = new OutputStreamWriter(os, encoding); 
						exportReportToWriter();
					}
					catch (IOException e)
					{
						throw new JRException("Error writing to OutputStream writer : " + jasperPrint.getName(), e);
					}
				}
				else
				{
					File destFile = (File)parameters.get(JRExporterParameter.OUTPUT_FILE);
					if (destFile == null)
					{
						String fileName = (String)parameters.get(JRExporterParameter.OUTPUT_FILE_NAME);
						if (fileName != null)
						{
							destFile = new File(fileName);
						}
						else
						{
							throw new JRException("No output specified for the exporter.");
						}
					}

					try
					{
						os = new FileOutputStream(destFile);
						writer = new OutputStreamWriter(os, encoding);
						exportReportToWriter();
					}
					catch (IOException e)
					{
						throw new JRException("Error writing to file writer : " + jasperPrint.getName(), e);
					}
					finally
					{
						if (writer != null)
						{
							try
							{
								writer.close();
							}
							catch(IOException e)
							{
							}
						}
					}
				}
			}
		}
	}


	/**
	 *
	 */
	protected void exportReportToWriter() throws JRException, IOException
	{
		for(int reportIndex = 0; reportIndex < jasperPrintList.size(); reportIndex++)
		{
			jasperPrint = (JasperPrint)jasperPrintList.get(reportIndex);

			List pages = jasperPrint.getPages();
			if (pages != null && pages.size() > 0)
			{
				if (isModeBatch)
				{
					startPageIndex = 0;
					endPageIndex = pages.size() - 1;
				}

				for(int i = startPageIndex; i <= endPageIndex; i++)
				{
					if (Thread.currentThread().isInterrupted())
					{
						throw new JRException("Current thread interrupted.");
					}
				
					JRPrintPage page = (JRPrintPage)pages.get(i);

					/*   */
					exportPage(page);
				}
			}
		}
				
		writer.flush();
	}


	/**
	 *
	 */
	protected void exportPage(JRPrintPage page) throws IOException
	{
		JRGridLayout layout = new JRGridLayout(page.getElements(), null, 
				jasperPrint.getPageWidth(), jasperPrint.getPageHeight(), globalOffsetX, globalOffsetY,
				JRGridLayout.TEXT_EXPORTER,
				true, false, false, null);
		
		JRExporterGridCell[][] grid = layout.getGrid();
		boolean[] isRowUsed = layout.getIsRowNotEmpty();
		boolean[] isColUsed = layout.getIsColumnNotEmpty();

		StringBuffer rowbuffer = null;
		
		JRPrintElement element = null;
		String text = null;
		boolean isFirstColumn = true;
		for(int y = 0; y < grid.length; y++)
		{
			rowbuffer = new StringBuffer();

			if (isRowUsed[y])
			{
				isFirstColumn = true;
				for(int x = 0; x < grid[y].length; x++)
				{
					if(grid[y][x].element != null)
					{
						element = grid[y][x].element;
	
						if (element instanceof JRPrintText)
						{
							JRStyledText styledText = getStyledText((JRPrintText)element);
							if (styledText == null)
							{
								text = "";
							}
							else
							{
								text = styledText.getText();
							}
							
							if (!isFirstColumn)
							{
								rowbuffer.append(delimiter);
							}
							rowbuffer.append(
								prepareText(text)
								);
							isFirstColumn = false;
						}
					}
					else
					{
						if (isColUsed[x])
						{
							if (!isFirstColumn)
							{
								rowbuffer.append(delimiter);
							}
							isFirstColumn = false;
						}
					}
				}
				
				if (rowbuffer.length() > 0)
				{
					writer.write(rowbuffer.toString());
					writer.write(recordDelimiter);
				}
			}
		}
		
		if (progressMonitor != null)
		{
			progressMonitor.afterPageExport();
		}
	}
	
	
	/**
	 *
	 */
	protected JRStyledText getStyledText(JRPrintText textElement)
	{
		JRStyledText styledText = null;

		String text = textElement.getText();
		if (text != null)
		{
			if (textElement.isStyledText())
			{
				try
				{
					styledText = styledTextParser.parse(null, text);
				}
				catch (SAXException e)
				{
					//ignore if invalid styled text and treat like normal text
				}
			}
		
			if (styledText == null)
			{
				styledText = new JRStyledText();
				styledText.append(text);
				styledText.addRun(new JRStyledText.Run(null, 0, text.length()));
			}
		}
		
		return styledText;
	}


	/**
	 *
	 */
	protected String prepareText(String source)
	{
		String str = null;
		
		if (source != null)
		{
			boolean putQuotes = false;
			
			if (source.indexOf(delimiter) >= 0)
			{
				putQuotes = true;
			}
			
			StringBuffer sbuffer = new StringBuffer();
			StringTokenizer tkzer = new StringTokenizer(source, ",\"\n", true);
			String token = null;
			while(tkzer.hasMoreTokens())
			{
				token = tkzer.nextToken();
				if (",".equals(token))
				{
					putQuotes = true;
					sbuffer.append(",");
				}
				else if ("\"".equals(token))
				{
					putQuotes = true;
					sbuffer.append("\"\"");
				}
				else if ("\n".equals(token))
				{
					//sbuffer.append(" ");
					putQuotes = true;
					sbuffer.append("\n");
				}
				else
				{
					sbuffer.append(token);
				}
			}
			
			str = sbuffer.toString();
			
			if (putQuotes)
			{
				str = "\"" + str + "\"";
			}
		}
		
		return str;
	}


}
