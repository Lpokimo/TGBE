package com.tbge.engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Input implements KeyListener, MouseListener, MouseMotionListener,  MouseWheelListener {

	private GameContainer gc;
	
	private final int NUM_KEYS = 256;
	private boolean[] keys = new boolean[NUM_KEYS];
	private boolean[] keysLAST = new boolean[NUM_KEYS];
	
	private final int NUM_BUTTONS = 5;
	private boolean[] buttons = new boolean[NUM_KEYS];
	private boolean[] buttonslast = new boolean[NUM_KEYS];
	
	private int mouseX, mouseY;
	private int scroll;
	
	public Input(GameContainer gc) {
        this.gc = gc;
        this.mouseX = 0;
        this.mouseY = 0;
        this.scroll = 0;

        gc.getWindow().getCanvas().addKeyListener(null);
        gc.getWindow().getCanvas().addMouseListener(null);
        gc.getWindow().getCanvas().addMouseMotionListener(null);
        gc.getWindow().getCanvas().addMouseWheelListener(null);


        for (int i = 0; i < keys.length; i++) {
            keys[i] = false;
        }

		
		for(int i  = 0; i < NUM_BUTTONS; i++) {
			buttonslast[i] = buttons[i];
		}

	}
	
	public boolean isKey(int keyCode)
	{
		return keys[keyCode];
	}
	public boolean isKeyUp(int keyCode)
	{
		return !keys[keyCode] && keysLAST[keyCode];
	}
	
	public boolean isKeyDown(int keyCode)
	{
		return keys[keyCode] && !keysLAST[keyCode];
	}
	
	
	public boolean isButton(int button)
	{
		return buttons[button];
	}
	public boolean iButtonup(int button)
	{
		return !buttons[button] && buttonslast[button];
	}
	
	public boolean isButtonDown(int button)
	{
		return buttons[button] && !buttonslast[button];
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		scroll = e.getWheelRotation();		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseX = (int)(e.getX() / gc.getScale());
		mouseY = (int)(e.getY() / gc.getScale());
		
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = (int)(e.getX() / gc.getScale());
		mouseY = (int)(e.getY() / gc.getScale());
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		buttons[e.getButton()] = true;
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		buttons[e.getButton()] = false;
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		keys[e.getKeyCode()] = false;
	}

	public int getMouseX() {
		return mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}

	public int getScroll() {
		return scroll;
	}

}
