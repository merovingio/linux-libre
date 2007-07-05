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
package net.sf.jasperreports.engine.xml;

import net.sf.jasperreports.engine.JRHyperlink;
import net.sf.jasperreports.engine.design.JRDesignHyperlink;

import org.xml.sax.Attributes;


/**
 * Factory used to create {@link JRHyperlink hyperlink} for stand-alone JRXML hyperlink specifications.
 * 
 * @author Lucian Chirita (lucianc@users.sourceforge.net)
 * @version $Id: JRHyperlinkFactory.java 1364 2006-08-31 18:13:20 +0300 (Thu, 31 Aug 2006) lucianc $
 */
public class JRHyperlinkFactory extends JRBaseFactory
{
	public static final String ELEMENT_HYPERLINK_TOOLTIP_EXPRESSION = "hyperlinkTooltipExpression";
	public static final String ELEMENT_SECTION_HYPERLINK = "sectionHyperlink";
	public static final String ELEMENT_ITEM_HYPERLINK = "itemHyperlink";
	
	public static final String ATTRIBUTE_hyperlinkType = "hyperlinkType";
	public static final String ATTRIBUTE_hyperlinkTarget = "hyperlinkTarget";

	public Object createObject(Attributes atts) throws Exception
	{
		JRDesignHyperlink link = new JRDesignHyperlink();

		String hyperlinkType = atts.getValue(ATTRIBUTE_hyperlinkType);
		if (hyperlinkType != null)
		{
			link.setLinkType(hyperlinkType);
		}

		Byte hyperlinkTarget = (Byte)JRXmlConstants.getHyperlinkTargetMap().get(atts.getValue(ATTRIBUTE_hyperlinkTarget));
		if (hyperlinkTarget != null)
		{
			link.setHyperlinkTarget(hyperlinkTarget.byteValue());
		}

		return link;
	}

}
