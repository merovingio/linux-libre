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
package net.sf.jasperreports.charts.design;

import net.sf.jasperreports.charts.JRPieDataset;
import net.sf.jasperreports.engine.JRChartDataset;
import net.sf.jasperreports.engine.JRConstants;
import net.sf.jasperreports.engine.JRExpression;
import net.sf.jasperreports.engine.JRExpressionCollector;
import net.sf.jasperreports.engine.JRHyperlink;
import net.sf.jasperreports.engine.design.JRDesignChartDataset;
import net.sf.jasperreports.engine.design.JRVerifier;



/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: JRDesignPieDataset.java 1368 2006-09-01 15:01:52 +0300 (Fri, 01 Sep 2006) lucianc $
 */
public class JRDesignPieDataset extends JRDesignChartDataset implements JRPieDataset
{


	/**
	 *
	 */
	private static final long serialVersionUID = JRConstants.SERIAL_VERSION_UID;

	protected JRExpression keyExpression = null;
	protected JRExpression valueExpression = null;
	protected JRExpression labelExpression = null;
	private JRHyperlink sectionHyperlink;


	/**
	 *
	 */
	public JRDesignPieDataset(JRChartDataset dataset)
	{
		super(dataset);
	}


	/**
	 *
	 */
	public JRExpression getKeyExpression()
	{
		return keyExpression;
	}
		
	/**
	 *
	 */
	public void setKeyExpression(JRExpression keyExpression)
	{
		this.keyExpression = keyExpression;
	}

	/**
	 *
	 */
	public JRExpression getValueExpression()
	{
		return valueExpression;
	}
		
	/**
	 *
	 */
	public void setValueExpression(JRExpression valueExpression)
	{
		this.valueExpression = valueExpression;
	}

	/**
	 *
	 */
	public JRExpression getLabelExpression()
	{
		return labelExpression;
	}
		
	/**
	 *
	 */
	public void setLabelExpression(JRExpression labelExpression)
	{
		this.labelExpression = labelExpression;
	}


	/** 
	 * 
	 */
	public byte getDatasetType() {
		return JRChartDataset.PIE_DATASET;
	}
	
	
	/**
	 *
	 */
	public void collectExpressions(JRExpressionCollector collector)
	{
		collector.collect(this);
	}

	
	public JRHyperlink getSectionHyperlink()
	{
		return sectionHyperlink;
	}


	/**
	 * Sets the hyperlink specification for chart sections.
	 * 
	 * @param sectionHyperlink the hyperlink specification
	 * @see #getSectionHyperlink()
	 */
	public void setSectionHyperlink(JRHyperlink sectionHyperlink)
	{
		this.sectionHyperlink = sectionHyperlink;
	}


	public void validate(JRVerifier verifier)
	{
		verifier.verify(this);
	}


}
