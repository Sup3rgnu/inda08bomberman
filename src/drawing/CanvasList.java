/***
 * 
 * Copyright (C) 2008 Alessandro La Rosa
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 * Contact: alessandro.larosa@gmail.com
 *
 * Author: Alessandro La Rosa
 */

import java.util.Vector;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class CanvasList extends Canvas
{
	protected int linePadding = 2;
	protected int margin = 2;
	protected int padding = 2;
	protected Font font = Font.getDefaultFont();
	
	protected int bgColor = 0xffffff;
	
	protected int foreColor = 0x000000;
	protected int foreSelectedColor = 0xffffff;
	protected int backColor = 0xffffff;
	protected int backSelectedColor = 0x0000ff;
	
	protected int borderWidth = 3;
	protected int borderColor = 0x000000;
	protected int borderSelectedColor = 0xff0000;
	
	// will contain item splitted lines
	String[][] itemLines = null;
	// will hold items image parts
	Image[] images = null;
	// will hold selected item index
	public int selectedItem = 0;
	
	// these will hold item graphical properties
	int[] itemsTop = null;
	int[] itemsHeight = null;
	
	// these will hold List vertical scrolling
	int scrollTop = 0;
	final int SCROLL_STEP = 40;
	
	public CanvasList(String title, String[] items, Image[] imageElements)
	{
		setTitle(title);
		
		this.images = imageElements;
		
		itemLines = new String[items.length][];
		
		itemsTop = new int[itemLines.length];
		itemsHeight = new int[itemLines.length];
		
		for(int i = 0; i < itemLines.length; i++)
		{
			// get image part of this item, if available
			Image imagePart = getImage(i);
			
			// get avaiable width for text
			int w = getItemWidth() - (imagePart != null ? imagePart.getWidth() + padding : 0);
			
			// and split item text into text rows, to fit available width 
			itemLines[i] = getTextRows((String) items[i], font, w);
		}
	}
	public int getItemWidth()
	{
		return getWidth() - 2 * borderWidth - 2 * padding - 2 * margin;
	}
	protected void keyPressed(int key)
	{
		int keyCode = getGameAction(key);
		
		// is there 1 item at least?
		if(itemLines.length > 0)
		{
			// going up
			if(keyCode == Canvas.UP)
			{
				// current item is clipped on top, so can scroll up
				if(itemsTop[selectedItem] < scrollTop)
				{
					scrollTop -= SCROLL_STEP;
					
					repaint();
				}
				// is there a previous item?
				else if(selectedItem > 0)
				{
					selectedItem--;
					
					repaint();
				}
			}
			//going down
			else if(keyCode == Canvas.DOWN)
			{
				// current item is clipped on bottom, so can scroll down
				if(itemsTop[selectedItem] + itemsHeight[selectedItem] >= scrollTop + getHeight())
				{
					scrollTop += SCROLL_STEP;
					
					repaint();
				}
				// is there a following item?
				else if(selectedItem < itemLines.length - 1)
				{
					selectedItem++;
					
					repaint();
				}
			}
		}
	}
	
	Image getImage(int index)
	{
		return images != null && images.length > index ? images[index] : null;
	}
	
	protected void paint(Graphics g)
	{
		// paint List background
		g.setColor(bgColor);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		// translate accordingly to current List vertical scroll
		g.translate(0, - scrollTop);
		
		int top = 0;
		
		g.setFont(font);
		
		// loop List items
		for(int i = 0; i < itemLines.length; i++)
		{
			int itemRows = itemLines[i].length;
			
			Image imagePart = getImage(i);
			
			int itemHeight = itemRows * font.getHeight() + linePadding * (itemRows - 1);
			
			itemsTop[i] = top;
			itemsHeight[i] = itemHeight;
			
			// is image part higher than the text part?
			if(imagePart != null && imagePart.getHeight() > itemHeight)
			{
				itemHeight = imagePart.getHeight();
			}
			itemHeight += 2 * padding + 2 * borderWidth;
			
			g.translate(0, top);
			
			if(borderWidth > 0)
			{
				// paint item border
				g.setColor(i == selectedItem ? borderSelectedColor : borderColor);
				g.fillRect(margin, margin, getWidth() - 2 * margin, itemHeight);
			}
			
			// paint item background
			g.setColor(i == selectedItem ? backSelectedColor : backColor);
			g.fillRect(margin + borderWidth, margin + borderWidth, getWidth() - 2 * margin - 2 * borderWidth, itemHeight - 2 * borderWidth);
			
			// has this item an image part?
			if(imagePart != null)
			{
				g.drawImage(imagePart, margin + borderWidth + padding, margin + borderWidth + padding, Graphics.TOP | Graphics.LEFT);
			}
			
			// paint item text rows
			g.setColor(i == selectedItem ? foreSelectedColor : foreColor);
			
			int textLeft = margin + borderWidth + padding + (imagePart != null ? imagePart.getWidth() + padding : 0);
			
			for(int j = 0; j < itemRows; j++)
			{
				g.drawString(itemLines[i][j], textLeft, margin + borderWidth + padding + j * (linePadding + font.getHeight()), Graphics.TOP | Graphics.LEFT);
			}
			
			g.translate(0, - top);
			
			top += itemHeight + 2 * margin;
		}
		// finally, translate back
		g.translate(0, scrollTop);
	}
	
	static String[] getTextRows(String text, Font font, int width)
	{
		char SPACE_CHAR = ' ';
		String VOID_STRING = "";
		
		int prevIndex = 0;
		int currIndex = text.indexOf(SPACE_CHAR);
	
		Vector rowsVector = new Vector();
		
		StringBuffer stringBuffer = new StringBuffer();
		
		String currentToken;
		
		String currentRowText = VOID_STRING;
	
		while(prevIndex != -1)
		{
			int startCharIndex = prevIndex == 0 ? prevIndex : prevIndex + 1;
			
			if(currIndex != -1)
				currentToken = text.substring(startCharIndex, currIndex);
			else
				currentToken = text.substring(startCharIndex);
			
			prevIndex = currIndex;
			
			currIndex = text.indexOf(SPACE_CHAR, prevIndex + 1);
			
			if(currentToken.length() == 0)
			{
				continue;
			}
			
			if(stringBuffer.length() > 0)
	    		stringBuffer.append(SPACE_CHAR);
			
			stringBuffer.append(currentToken);
				
		    if(font.stringWidth(stringBuffer.toString()) > width) 
		    {
		    	if(currentRowText.length() > 0)
		    	{
		    		rowsVector.addElement(currentRowText);
		    	}
		        stringBuffer.setLength(0);
		        
		        currentRowText = VOID_STRING;
		        
		        stringBuffer.append(currentToken);
		        	
		        currentRowText = stringBuffer.toString();
		    }
		    else
		    {
		    	currentRowText = stringBuffer.toString();
		    }
		}
		if(currentRowText.length() > 0)
	    {
	    	rowsVector.addElement(currentRowText);
	    }
		String[] rowsArray = new String[rowsVector.size()];
		
		rowsVector.copyInto(rowsArray);
	
		return rowsArray;
	}
}
