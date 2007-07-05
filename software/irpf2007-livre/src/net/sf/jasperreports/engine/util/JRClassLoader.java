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
package net.sf.jasperreports.engine.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: JRClassLoader.java 1229 2006-04-19 13:27:35 +0300 (Wed, 19 Apr 2006) teodord $
 */
public class JRClassLoader extends ClassLoader
{

	/**
	 *
	 */
	protected JRClassLoader()
	{
		super();
	}

	/**
	 *
	 */
	protected JRClassLoader(ClassLoader parent)
	{
		super(parent);
	}


	/**
	 *
	 */
	public static Class loadClassForName(String className) throws ClassNotFoundException
	{
		Class clazz = null;

		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		if (classLoader != null)
		{
			try
			{
				clazz = Class.forName(className, true, classLoader);
			}
			catch (ClassNotFoundException e)
			{
				//if (log.isWarnEnabled())
				//	log.warn("Failure using Thread.currentThread().getContextClassLoader() in JRClassLoader class. Using JRClassLoader.class.getClassLoader() instead.");
			}
		}

		if (clazz == null)
		{
			classLoader = JRClassLoader.class.getClassLoader();
			if (classLoader == null)
			{
				clazz = Class.forName(className);
			}
			else
			{
				clazz = Class.forName(className, true, classLoader);
			}
		}

		return clazz;
	}


	/**
	 * @deprecated To be removed in future versions.
	 */
	public static Class loadClassFromFile(String className, File file) throws IOException
	{
		Class clazz = null;

		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		if (classLoader != null)
		{
			try
			{
				clazz = 
					(new JRClassLoader(classLoader))
						.loadClass(className, file);
			}
			catch(NoClassDefFoundError e)
			{
				//if (log.isWarnEnabled())
				//	log.warn("Failure using Thread.currentThread().getContextClassLoader() in JRClassLoader class. Using JRClassLoader.class.getClassLoader() instead.");
			}
		}
	
		if (clazz == null)
		{
			classLoader = JRClassLoader.class.getClassLoader();
			if (classLoader == null)
			{
				clazz = 
					(new JRClassLoader())
						.loadClass(className, file);
			}
			else
			{
				clazz = 
					(new JRClassLoader(classLoader))
						.loadClass(className, file);
			}
		}
		
		return clazz;
	}


	/**
	 *
	 */
	public static Class loadClassFromBytes(String className, byte[] bytecodes)
	{
		Class clazz = null;

		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		if (classLoader != null)
		{
			try
			{
				clazz = 
					(new JRClassLoader(classLoader))
						.loadClass(className, bytecodes);
			}
			catch(NoClassDefFoundError e)
			{
				//if (log.isWarnEnabled())
				//	log.warn("Failure using Thread.currentThread().getContextClassLoader() in JRClassLoader class. Using JRClassLoader.class.getClassLoader() instead.");
			}
		}
	
		if (clazz == null)
		{
			classLoader = JRClassLoader.class.getClassLoader();
			if (classLoader == null)
			{
				clazz = 
					(new JRClassLoader())
						.loadClass(className, bytecodes);
			}
			else
			{
				clazz = 
					(new JRClassLoader(classLoader))
						.loadClass(className, bytecodes);
			}
		}

		return clazz;
	}


	/**
	 * @deprecated To be removed in future versions.
	 */
	protected Class loadClass(String className, File file) throws IOException
	{
		FileInputStream fis = null;
		ByteArrayOutputStream baos = null;

		byte[] bytecodes = new byte[10000];
		int ln = 0;

		try
		{
			fis = new FileInputStream(file);
			baos = new ByteArrayOutputStream();

			while ( (ln = fis.read(bytecodes)) > 0 )
			{
				baos.write(bytecodes, 0, ln);
			}

			baos.flush();
		}
		finally
		{
			if (baos != null)
			{
				try
				{
					baos.close();
				}
				catch(IOException e)
				{
				}
			}

			if (fis != null)
			{
				try
				{
					fis.close();
				}
				catch(IOException e)
				{
				}
			}
		}

		return loadClass(className, baos.toByteArray());
	}


	/**
	 *
	 */
	protected Class loadClass(String className, byte[] bytecodes)
	{
		Class clazz = null;

		clazz = 
			defineClass(
				className, 
				bytecodes, 
				0, 
				bytecodes.length,
				JRClassLoader.class.getProtectionDomain()
				);

		return clazz;
	}


}
