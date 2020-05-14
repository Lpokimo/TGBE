package com.tbge.engine;

import java.awt.image.DataBufferInt;

public class Renderer {

	private int pW, pH;
	private int[] p;
	
	public Renderer(GameContainer gc)
	{
		setpW(gc.getWidth());
		setpH(gc.getHeight());
		p = ((DataBufferInt)gc.getWindow().getImage().getRaster().getDataBuffer()).getData();
	}
	
	public void clear()
	{
		for(int i = 0; i < p.length; i++)
		{
			p[i] = i;
		}
	}

	public int getpW() {
		return pW;
	}

	public void setpW(int pW) {
		this.pW = pW;
	}

	public int getpH() {
		return pH;
	}

	public void setpH(int pH) {
		this.pH = pH;
	}
}
