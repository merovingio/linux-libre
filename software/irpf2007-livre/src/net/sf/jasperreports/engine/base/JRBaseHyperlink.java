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
package net.sf.jasperreports.engine.base;

import java.io.Serializable;

import net.sf.jasperreports.engine.JRConstants;
import net.sf.jasperreports.engine.JRExpression;
import net.sf.jasperreports.engine.JRHyperlink;
import net.sf.jasperreports.engine.JRHyperlinkHelper;
import net.sf.jasperreports.engine.JRHyperlinkParameter;

/**
 * Read-only implementation of {@link JRHyperlink JRHyperlink}.
 * 
 * @author Lucian Chirita (lucianc@users.sourceforge.net)
 * @version $Id: JRBaseHyperlink.java 1364 2006-08-31 18:13:20 +0300 (Thu, 31 Aug 2006) lucianc $
 */
public class JRBaseHyperlink implements JRHyperlink, Serializable
{
	
	private static final long serialVersionUID = JRConstants.SERIAL_VERSION_UID;
	
	protected String linkType;
	protected byte hyperlinkTarget = JRHyperlink.HYPERLINK_TARGET_SELF;
	protected JRExpression hyperlinkReferenceExpression;
	protected JRExpression hyperlinkAnchorExpression;
	protected JRExpression hyperlinkPageExpression;
	protected JRExpression hyperlinkTooltipExpression;
	protected JRHyperlinkParameter[] hyperlinkParameters;

	
	/**
	 * Create an empty hyperlink.
	 */
	public JRBaseHyperlink()
	{
	}

	
	protected JRBaseHyperlink(JRHyperlink link, JRBaseObjectFactory factory)
	{
		factory.put(link, this);
		
		linkType = link.getLinkType();
		hyperlinkTarget = link.getHyperlinkTarget();
		hyperlinkReferenceExpression = factory.getExpression(link.getHyperlinkReferenceExpression());
		hyperlinkAnchorExpression = factory.getExpression(link.getHyperlinkAnchorExpression());
		hyperlinkPageExpression = factory.getExpression(link.getHyperlinkPageExpression());
		hyperlinkTooltipExpression = factory.getExpression(link.getHyperlinkTooltipExpression());
		hyperlinkParameters = copyHyperlinkParameters(link, factory);
	}

	public static JRHyperlinkParameter[] copyHyperlinkParameters(JRHyperlink link, JRBaseObjectFactory factory)
	{
		JRHyperlinkParameter[] linkParameters = link.getHyperlinkParameters();
		JRHyperlinkParameter[] parameters = null;
		if (linkParameters != null && linkParameters.length > 0)
		{
			parameters = new JRHyperlinkParameter[linkParameters.length];
			for (int i = 0; i < linkParameters.length; i++)
			{
				JRHyperlinkParameter parameter = linkParameters[i];
				parameters[i] = factory.getHyperlinkParameter(parameter);
			}
		}
		return parameters;
	}
	
	public JRExpression getHyperlinkAnchorExpression()
	{
		return hyperlinkAnchorExpression;
	}

	public JRExpression getHyperlinkPageExpression()
	{
		return hyperlinkPageExpression;
	}

	public JRHyperlinkParameter[] getHyperlinkParameters()
	{
		return hyperlinkParameters;
	}

	public JRExpression getHyperlinkReferenceExpression()
	{
		return hyperlinkReferenceExpression;
	}

	public byte getHyperlinkTarget()
	{
		return hyperlinkTarget;
	}

	public byte getHyperlinkType()
	{
		return JRHyperlinkHelper.getHyperlinkType(this);
	}

	public String getLinkType()
	{
		return linkType;
	}
	
	public JRExpression getHyperlinkTooltipExpression()
	{
		return hyperlinkTooltipExpression;
	}

}
