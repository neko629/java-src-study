/*
 * Copyright (c) 2011, 2015, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package com.sun.glass.ui.mac;

import com.sun.glass.events.WindowEvent;
import com.sun.glass.events.mac.NpapiEvent;
import com.sun.glass.ui.Cursor;
import com.sun.glass.ui.Pixels;
import com.sun.glass.ui.Screen;
import com.sun.glass.ui.View;
import com.sun.glass.ui.Window;

import java.util.Map;

/**
 * MacOSX platform implementation class for Window.
 */
final class MacWindow extends Window {

    private native static void _initIDs();
    static {
        _initIDs();
    }

    protected MacWindow(Window owner, Screen screen, int styleMask) {
        super(owner, screen, styleMask);
        setPlatformScale(screen.getUIScale());
        setRenderScale(screen.getRenderScale());
    }
    protected MacWindow(long parent) {
        super(parent);
    }

    @Override
    protected void setScreen(Screen screen) {
        // SceneState will be called to update with new scale values
        // before we return from super.setScreen()...
        setRenderScale(screen.getUIScale());
        setRenderScale(screen.getRenderScale());
        super.setScreen(screen);
    }

    @Override
    public float getOutputScale() {
        return getRenderScale();
    }

    @Override native protected long _createWindow(long ownerPtr, long screenPtr, int mask);
    @Override native protected long _createChildWindow(long parent);
    @Override native protected boolean _close(long ptr);
    @Override native protected boolean _setView(long ptr, View view);
    @Override native protected boolean _setMenubar(long ptr, long menubarPtr);
    @Override native protected boolean _minimize(long ptr, boolean minimize);
    @Override native protected boolean _maximize(long ptr, boolean maximize, boolean wasMaximized);
    @Override native protected void _setBounds(long ptr, int x, int y, boolean xSet, boolean ySet, int w, int h, int cw, int ch, float xGravity, float yGravity);
    @Override native protected boolean _setVisible(long ptr, boolean visible);
    @Override native protected boolean _setResizable(long ptr, boolean resizable);

    native private boolean _requestFocus(long ptr);
    @Override protected boolean _requestFocus(long ptr, int event) {
        //TODO: provide reasonable impl for all possible events
        if (event != WindowEvent.FOCUS_LOST) {
            return _requestFocus(ptr);
        }
        return false;
    }

    @Override native protected void _setFocusable(long ptr, boolean isFocusable);
    @Override native protected boolean _setTitle(long ptr, String title);
    @Override native protected void _setLevel(long ptr, int level);
    @Override native protected void _setAlpha(long ptr, float alpha);
    @Override native protected boolean _setBackground(long ptr, float r, float g, float b);
    @Override native protected void _setEnabled(long ptr, boolean enabled);
    @Override native protected boolean _setMinimumSize(long ptr, int width, int height);
    @Override native protected boolean _setMaximumSize(long ptr, int width, int height);
    @Override native protected void _setIcon(long ptr, Pixels pixels);
    @Override native protected void _toFront(long ptr);
    @Override native protected void _toBack(long ptr);
    @Override native protected void _enterModal(long ptr);
    @Override native protected void _enterModalWithWindow(long dialog, long window);
    @Override native protected void _exitModal(long ptr);

    @Override native protected boolean _grabFocus(long ptr);
    @Override native protected void _ungrabFocus(long ptr);

    @Override native protected int _getEmbeddedX(long ptr);
    @Override native protected int _getEmbeddedY(long ptr);

    @Override
    protected void _setCursor(long ptr, Cursor cursor) {
        ((MacCursor)cursor).set();
    }

    @Override
    public void dispatchNpapiEvent(Map eventInfo) {
        NpapiEvent.dispatchCocoaNpapiEvent(this, eventInfo);
    }

    @Override
    protected void _requestInput(long ptr, String text, int type, double width, double height,
                                    double Mxx, double Mxy, double Mxz, double Mxt,
                                    double Myx, double Myy, double Myz, double Myt,
                                    double Mzx, double Mzy, double Mzz, double Mzt) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void _releaseInput(long ptr) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

