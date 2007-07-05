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
package net.sf.jasperreports.engine;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;

import net.sf.jasperreports.engine.design.JRDefaultCompiler;
import net.sf.jasperreports.engine.design.JRVerifier;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.engine.xml.JRXmlWriter;


/**
 * Fa�ade class for compiling report designs into the ready-to-fill form
 * and for getting the XML representation of report design objects for
 * storage or network transfer.
 * 
 * Report compilation using this class is delegated to the
 * {@link net.sf.jasperreports.engine.design.JRDefaultCompiler}.
 * 
 * @see net.sf.jasperreports.engine.design.JasperDesign
 * @see net.sf.jasperreports.engine.JasperReport
 * @see net.sf.jasperreports.engine.design.JRDefaultCompiler
 * @see net.sf.jasperreports.engine.design.JRVerifier
 * @see net.sf.jasperreports.engine.xml.JRXmlLoader
 * @see net.sf.jasperreports.engine.xml.JRXmlWriter
 * @see net.sf.jasperreports.engine.util.JRLoader
 * @see net.sf.jasperreports.engine.util.JRSaver
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: JasperCompileManager.java 1229 2006-04-19 13:27:35 +0300 (Wed, 19 Apr 2006) teodord $
 */
public class JasperCompileManager
{


	/**
	 * Compiles the XML report design file specified by the parameter.
	 * The result of this operation is another file that will contain the serialized  
	 * {@link net.sf.jasperreports.engine.JasperReport} object representing the compiled report design,
	 * having the same name as the report design as declared in the XML plus the <code>*.jasper</code> extension,
	 * located in the same directory as the XML source file.
	 * 
	 * @param sourceFileName XML source file name
	 * @return resulting file name containing a serialized {@link net.sf.jasperreports.engine.JasperReport} object 
	 */
	public static String compileReportToFile(String sourceFileName) throws JRException
	{
		File sourceFile = new File(sourceFileName);

		JasperDesign jasperDesign = JRXmlLoader.load(sourceFileName);

		File destFile = new File(sourceFile.getParent(), jasperDesign.getName() + ".jasper");
		String destFileName = destFile.toString();

		compileReportToFile(jasperDesign, destFileName);
		
		return destFileName;
	}


	/**
	 * Compiles the XML report design file received as the first parameter, placing the result 
	 * in the file specified by the second parameter.
	 * The resulting file will contain a serialized instance of a 
	 * {@link net.sf.jasperreports.engine.JasperReport} object representing 
	 * the compiled report design. 
	 * 
	 * @param sourceFileName XML source file name
	 * @param destFileName   file name to place the result into
	 */
	public static void compileReportToFile(
		String sourceFileName,
		String destFileName
		) throws JRException
	{
		JasperDesign jasperDesign = JRXmlLoader.load(sourceFileName);

		compileReportToFile(jasperDesign, destFileName);
	}


	/**
	 * Compiles the report design object received as the first parameter, placing the result 
	 * in the file specified by the second parameter.
	 * The resulting file will contain a serialized instance of a 
	 * {@link net.sf.jasperreports.engine.JasperReport} object representing the compiled report design.
	 * 
	 * @param jasperDesign source report design object
	 * @param destFileName file name to place the compiled report design into
	 */
	public static void compileReportToFile(
		JasperDesign jasperDesign,
		String destFileName
		) throws JRException
	{
		JasperReport jasperReport = JRDefaultCompiler.getInstance().compileReport(jasperDesign);

		JRSaver.saveObject(jasperReport, destFileName);
	}


	/**
	 * Compiles the XML report design file received as parameter, and returns 
	 * the compiled report design object.
	 *  
	 * @param sourceFileName XML source file name
	 * @return compiled report design object 
	 */
	public static JasperReport compileReport(String sourceFileName) throws JRException
	{
		JasperDesign jasperDesign = JRXmlLoader.load(sourceFileName);

		return compileReport(jasperDesign);
	}


	/**
	 * Compiles the XML representation of the report design read from the supplied input stream and
	 * writes the generated compiled report design object to the output stream specified 
	 * by the second parameter.
	 * 
	 * @param inputStream  XML source input stream
	 * @param outputStream output stream to write the compiled report design to
	 */
	public static void compileReportToStream(
		InputStream inputStream,
		OutputStream outputStream
		) throws JRException
	{
		JasperDesign jasperDesign = JRXmlLoader.load(inputStream);

		compileReportToStream(jasperDesign, outputStream);
	}


	/**
	 * Compiles the report design object represented by the first parameter and
	 * writes the generated compiled report design object to the output stream specified 
	 * by the second parameter.
	 * 
	 * @param jasperDesign source report design object
	 * @param outputStream output stream to write the compiled report design to
	 */
	public static void compileReportToStream(
		JasperDesign jasperDesign,
		OutputStream outputStream
		) throws JRException
	{
		JasperReport jasperReport = JRDefaultCompiler.getInstance().compileReport(jasperDesign);

		JRSaver.saveObject(jasperReport, outputStream);
	}


	/**
	 * Compiles the serialized report design object read from the supplied input stream and
	 * returns the generated compiled report design object.
	 * 
	 * @param inputStream XML source input stream
	 * @return compiled report design object 
	 */
	public static JasperReport compileReport(InputStream inputStream) throws JRException
	{
		JasperDesign jasperDesign = JRXmlLoader.load(inputStream);

		return compileReport(jasperDesign);
	}


	/**
	 * Compiles the report design object received as parameter and
	 * returns the generated compiled report design object.
	 *
	 * @param jasperDesign source report design object
	 * @return compiled report design object 
	 * @see net.sf.jasperreports.engine.design.JRDefaultCompiler
	 */
	public static JasperReport compileReport(JasperDesign jasperDesign) throws JRException
	{
		return JRDefaultCompiler.getInstance().compileReport(jasperDesign);
	}


	/**
	 * Verifies the validity and consistency of the report design object.
	 * Returns a collection of error messages (String), if problems are found in the report design.
	 *
	 * @param jasperDesign report design object to verify
	 * @return collection of String messages if problems are found
	 * @see net.sf.jasperreports.engine.design.JRVerifier
	 */
	public static Collection verifyDesign(JasperDesign jasperDesign)
	{
		return JRVerifier.verifyDesign(jasperDesign);
	}


	/**
	 * Generates the XML representation of the report design loaded from the specified filename.
	 * The result of this operation is an "UTF-8" encoded XML file having the same name as 
	 * the report design, plus the <code>*.jasper.jrxml</code> extension, located in the same directory as 
	 * the source file.
	 * 
	 * @param sourceFileName source file name containing the report design object
	 * @return XML representation of the report design
	 */
	public static String writeReportToXmlFile(
		String sourceFileName
		) throws JRException
	{
		File sourceFile = new File(sourceFileName);

		/* We need the report name. */
		JRReport report = (JRReport)JRLoader.loadObject(sourceFile);

		File destFile = new File(sourceFile.getParent(), report.getName() + ".jasper.jrxml");
		String destFileName = destFile.toString();
		
		writeReportToXmlFile(
			report, 
			destFileName
			);
		
		return destFileName;
	}


	/**
	 * Generates the XML representation of the report design loaded from the first file parameter
	 * and place it in the file specified by the second parameter. The result is "UTF-8" encoded.
	 * 
	 * @param sourceFileName source file name containing the report design object
	 * @param destFileName   output file name to write the XML report design representation to
	 */
	public static void writeReportToXmlFile(
		String sourceFileName, 
		String destFileName
		) throws JRException
	{
		JRReport report = (JRReport)JRLoader.loadObject(sourceFileName);

		writeReportToXmlFile(
			report, 
			destFileName
			);
	}

	
	/**
	 * Generates the XML representation of the report design supplied as the first parameter
	 * and place it in the file specified by the second parameter. The result is "UTF-8" encoded.
	 *
	 * @param report       source report design object
	 * @param destFileName output file name to write the XML report design representation to
	 * @see net.sf.jasperreports.engine.xml.JRXmlWriter
	 */
	public static void writeReportToXmlFile(
		JRReport report,
		String destFileName
		) throws JRException
	{
		JRXmlWriter.writeReport(
			report,
			destFileName,
			"UTF-8"
			);
	}


	/**
	 * Generates the XML representation of the serialized report design object read from the supplied 
	 * input stream abd writes it to the specified output stream, using the "UTF-8" encoding.
	 * 
	 * @param inputStream  source input stream to read the report design object from
	 * @param outputStream output stream to write the XML report design representation to
	 */
	public static void writeReportToXmlStream(
		InputStream inputStream, 
		OutputStream outputStream
		) throws JRException
	{
		JRReport report = (JRReport)JRLoader.loadObject(inputStream);

		writeReportToXmlStream(report, outputStream);
	}

	
	/**
	 * Generates the XML representation of the report design object supplied as parameter
	 * and writes it to the specified output stream, using the "UTF-8" encoding.
	 *
	 * @param report       source report design object
	 * @param outputStream output stream to write the XML report design representation to
	 * @see net.sf.jasperreports.engine.xml.JRXmlWriter
	 */
	public static void writeReportToXmlStream(
		JRReport report, 
		OutputStream outputStream
		) throws JRException
	{
		JRXmlWriter.writeReport(
			report, 
			outputStream,
			"UTF-8"
			);
	}


	/**
	 * Generates the XML representation of the report design object supplied as parameter
	 * using the "UTF-8" enconding.
	 *
	 * @param report source report design object
	 * @return XML representation of the report design
	 * @see net.sf.jasperreports.engine.xml.JRXmlWriter
	 */
	public static String writeReportToXml(JRReport report)
	{
		return JRXmlWriter.writeReport(report, "UTF-8");
	}


}
