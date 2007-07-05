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

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.base.JRBasePrintImage;

import org.xml.sax.Attributes;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: JRPrintImageFactory.java 1364 2006-08-31 18:13:20 +0300 (Thu, 31 Aug 2006) lucianc $
 */
public class JRPrintImageFactory extends JRBaseFactory
{


	/**
	 *
	 */
	private static final String ATTRIBUTE_scaleImage = "scaleImage";
	private static final String ATTRIBUTE_hAlign = "hAlign";
	private static final String ATTRIBUTE_vAlign = "vAlign";
	private static final String ATTRIBUTE_isLazy = "isLazy";
	private static final String ATTRIBUTE_onErrorType = "onErrorType";
	private static final String ATTRIBUTE_hyperlinkType = "hyperlinkType";
	private static final String ATTRIBUTE_hyperlinkTarget = "hyperlinkTarget";
	private static final String ATTRIBUTE_anchorName = "anchorName";
	private static final String ATTRIBUTE_hyperlinkReference = "hyperlinkReference";
	private static final String ATTRIBUTE_hyperlinkAnchor = "hyperlinkAnchor";
	private static final String ATTRIBUTE_hyperlinkPage = "hyperlinkPage";
	public static final String ATTRIBUTE_hyperlinkTooltip = "hyperlinkTooltip";
	private static final String ATTRIBUTE_bookmarkLevel = "bookmarkLevel";


	/**
	 *
	 */
	public Object createObject(Attributes atts)
	{
		JasperPrint jasperPrint = (JasperPrint)digester.peek(digester.getCount() - 2);

		JRBasePrintImage image = new JRBasePrintImage(jasperPrint.getDefaultStyleProvider());

		Byte scaleImage = (Byte)JRXmlConstants.getScaleImageMap().get(atts.getValue(ATTRIBUTE_scaleImage));
		if (scaleImage != null)
		{
			image.setScaleImage(scaleImage);
		}

		Byte horizontalAlignment = (Byte)JRXmlConstants.getHorizontalAlignMap().get(atts.getValue(ATTRIBUTE_hAlign));
		if (horizontalAlignment != null)
		{
			image.setHorizontalAlignment(horizontalAlignment);
		}

		Byte verticalAlignment = (Byte)JRXmlConstants.getVerticalAlignMap().get(atts.getValue(ATTRIBUTE_vAlign));
		if (verticalAlignment != null)
		{
			image.setVerticalAlignment(verticalAlignment);
		}

		String isLazy = atts.getValue(ATTRIBUTE_isLazy);
		if (isLazy != null && isLazy.length() > 0)
		{
			image.setLazy(Boolean.valueOf(isLazy).booleanValue());
		}

		Byte onErrorType = (Byte)JRXmlConstants.getOnErrorTypeMap().get(atts.getValue(ATTRIBUTE_onErrorType));
		if (onErrorType != null)
		{
			image.setOnErrorType(onErrorType.byteValue());
		}

		String hyperlinkType = atts.getValue(ATTRIBUTE_hyperlinkType);
		if (hyperlinkType != null)
		{
			image.setLinkType(hyperlinkType);
		}

		Byte hyperlinkTarget = (Byte)JRXmlConstants.getHyperlinkTargetMap().get(atts.getValue(ATTRIBUTE_hyperlinkTarget));
		if (hyperlinkTarget != null)
		{
			image.setHyperlinkTarget(hyperlinkTarget.byteValue());
		}

		image.setAnchorName(atts.getValue(ATTRIBUTE_anchorName));
		image.setHyperlinkReference(atts.getValue(ATTRIBUTE_hyperlinkReference));
		image.setHyperlinkAnchor(atts.getValue(ATTRIBUTE_hyperlinkAnchor));
		
		String hyperlinkPage = atts.getValue(ATTRIBUTE_hyperlinkPage);
		if (hyperlinkPage != null)
		{
			image.setHyperlinkPage(new Integer(hyperlinkPage));
		}
		
		image.setHyperlinkTooltip(atts.getValue(ATTRIBUTE_hyperlinkTooltip));

		String bookmarkLevelAttr = atts.getValue(ATTRIBUTE_bookmarkLevel);
		if (bookmarkLevelAttr != null)
		{
			image.setBookmarkLevel(Integer.parseInt(bookmarkLevelAttr));
		}

		return image;
	}
	

}
