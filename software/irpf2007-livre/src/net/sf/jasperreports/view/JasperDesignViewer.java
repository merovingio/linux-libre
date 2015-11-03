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
package net.sf.jasperreports.view;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.io.InputStream;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRReport;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: JasperDesignViewer.java 1229 2006-04-19 13:27:35 +0300 (Wed, 19 Apr 2006) teodord $
 */
public class JasperDesignViewer extends javax.swing.JFrame 
{

	
	/** Creates new form JasperDesignViewer */
	public JasperDesignViewer(String sourceFile, boolean isXML)  throws JRException
	{
		initComponents();

		JRDesignViewer viewer = new JRDesignViewer(sourceFile, isXML);
		this.pnlMain.add(viewer, BorderLayout.CENTER);
	}

	
	/** Creates new form JasperDesignViewer */
	public JasperDesignViewer(InputStream is, boolean isXML) throws JRException
	{
		initComponents();

		JRDesignViewer viewer = new JRDesignViewer(is, isXML);
		this.pnlMain.add(viewer, BorderLayout.CENTER);
	}

	
	/** Creates new form JasperDesignViewer */
	public JasperDesignViewer(JRReport report) throws JRException
	{
		initComponents();

		JRDesignViewer viewer = new JRDesignViewer(report);
		this.pnlMain.add(viewer, BorderLayout.CENTER);
	}

	
	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	private void initComponents() {//GEN-BEGIN:initComponents
		pnlMain = new javax.swing.JPanel();

		setTitle("JasperDesignViewer");
		setIconImage(new javax.swing.ImageIcon(getClass().getResource("/net/sf/jasperreports/view/images/jricon.GIF")).getImage());
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				exitForm();
			}
		});

		pnlMain.setLayout(new java.awt.BorderLayout());

		getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);

		pack();
		
		Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
		java.awt.Dimension screenSize = toolkit.getScreenSize();
		int screenResolution = toolkit.getScreenResolution();
		float zoom = ((float) screenResolution) / JRViewer.REPORT_RESOLUTION;
		
		int height = (int) (550 * zoom);
		if (height > screenSize.getHeight())
		{
			height = (int) screenSize.getHeight();
		}		
		int width = (int) (750 * zoom);
		if (width > screenSize.getWidth())
		{
			width = (int) screenSize.getWidth();
		}
		
		java.awt.Dimension dimension = new java.awt.Dimension(width, height);
		setSize(dimension);
		setLocation((screenSize.width-width)/2,(screenSize.height-height)/2);
	}//GEN-END:initComponents

	/** Exit the Application */
	void exitForm() {//GEN-FIRST:event_exitForm
		System.exit(0);
	}//GEN-LAST:event_exitForm

	
	/**
	* @param args the command line arguments
	*/
	public static void main(String args[]) 
	{
		String fileName = null;
		boolean isXMLFile = false;

		if(args.length == 0)
		{
			usage();
			return;
		}
				
		int k = 0;
		while ( args.length > k )
		{
			if ( args[k].startsWith("-F") )
				fileName = args[k].substring(2);
			if ( args[k].startsWith("-XML") )
				isXMLFile = true;
			
			k++;	
		}

		try
		{
			viewReportDesign(fileName, isXMLFile);
		}
		catch (JRException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}

	
	/**
	*
	*/
	private static void usage()
	{
		System.out.println( "JasperDesignViewer usage:" );
		System.out.println( "\tjava JasperDesignViewer -XML -Ffile" );
	}

	
	/**
	*
	*/
	public static void viewReportDesign(String sourceFile, boolean isXML) throws JRException
	{
		JasperDesignViewer jasperDesignViewer = new JasperDesignViewer(sourceFile, isXML);
		jasperDesignViewer.setVisible(true);
	}

	
	/**
	*
	*/
	public static void viewReportDesign(InputStream is, boolean isXML) throws JRException
	{
		JasperDesignViewer jasperDesignViewer = new JasperDesignViewer(is, isXML);
		jasperDesignViewer.setVisible(true);
	}

	
	/**
	*
	*/
	public static void viewReportDesign(JRReport report) throws JRException
	{
		JasperDesignViewer jasperDesignViewer = new JasperDesignViewer(report);
		jasperDesignViewer.setVisible(true);
	}

	
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JPanel pnlMain;
	// End of variables declaration//GEN-END:variables

}