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
package net.sf.jasperreports.engine.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRConstants;
import net.sf.jasperreports.engine.JRDatasetParameter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExpression;
import net.sf.jasperreports.engine.base.JRBaseDatasetRun;

/**
 * Implementation of {@link net.sf.jasperreports.engine.JRDatasetRun JRDatasetRun} to be used for report desing.
 * 
 * @author Lucian Chirita (lucianc@users.sourceforge.net)
 * @version $Id: JRDesignDatasetRun.java 1229 2006-04-19 13:27:35 +0300 (Wed, 19 Apr 2006) teodord $
 */
public class JRDesignDatasetRun extends JRBaseDatasetRun
{
	private static final long serialVersionUID = JRConstants.SERIAL_VERSION_UID;

	private Map parametersMap;
	private List parametersList;
	
	
	/**
	 * Creates an empty dataset instantiation.
	 */
	public JRDesignDatasetRun()
	{
		parametersMap = new HashMap();
		parametersList = new ArrayList();
	}
	
	
	/**
	 * Adds a parameter value.
	 * 
	 * @param parameter the parameter value
	 * @throws JRException
	 * @see net.sf.jasperreports.engine.JRDatasetRun#getParameters()
	 */
	public void addParameter(JRDatasetParameter parameter) throws JRException
	{
		if (parametersMap.containsKey(parameter.getName()))
		{
			throw new JRException("Duplicate declaration of dataset parameter : " + parameter.getName());
		}
		
		parametersMap.put(parameter.getName(), parameter);
		parametersList.add(parameter);
	}
	
	
	/**
	 * Removes a parameter value.
	 * 
	 * @param parameterName the parameter name
	 * @return the removed parameter value
	 */
	public JRDatasetParameter removeParameter(String parameterName)
	{
		JRDatasetParameter param = (JRDatasetParameter) parametersMap.remove(parameterName);
		if (param != null)
		{
			parametersList.remove(param);
		}
		
		return param;
	}
	
	
	/**
	 * Removes a parameter value.
	 * 
	 * @param parameter the parameter value
	 * @return the paramter value
	 */
	public JRDatasetParameter removeParameter(JRDatasetParameter parameter)
	{
		JRDatasetParameter param = (JRDatasetParameter) parametersMap.remove(parameter.getName());
		if (param != null)
		{
			parametersList.remove(parameter);
		}
		
		return param;
	}

	
	/**
	 * Sets the connection expression.
	 * 
	 * @param connectionExpression the connection expression
	 * @see net.sf.jasperreports.engine.JRDatasetRun#getConnectionExpression()
	 */
	public void setConnectionExpression(JRExpression connectionExpression)
	{
		this.connectionExpression = connectionExpression;
	}

	
	/**
	 * Sets the sub dataset name.
	 * 
	 * @param datasetName the sub dataset name
	 * @see net.sf.jasperreports.engine.JRDatasetRun#getDatasetName()
	 */
	public void setDatasetName(String datasetName)
	{
		this.datasetName = datasetName;
	}

	
	/**
	 * Sets the data source expression.
	 * 
	 * @param dataSourceExpression the data source expression
	 * @see net.sf.jasperreports.engine.JRDatasetRun#getDataSourceExpression()
	 */
	public void setDataSourceExpression(JRExpression dataSourceExpression)
	{
		this.dataSourceExpression = dataSourceExpression;
	}

	
	/**
	 * Sets the parameters map expression.
	 * 
	 * @param parametersMapExpression the parameters map expression
	 * @see net.sf.jasperreports.engine.JRDatasetRun#getParametersMapExpression()
	 */
	public void setParametersMapExpression(JRExpression parametersMapExpression)
	{
		this.parametersMapExpression = parametersMapExpression;
	}

	public JRDatasetParameter[] getParameters()
	{
		JRDatasetParameter[] params = new JRDatasetParameter[parametersList.size()];
		parametersList.toArray(params);
		return params;
	}

}
