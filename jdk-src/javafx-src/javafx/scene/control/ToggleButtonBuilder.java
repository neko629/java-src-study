/*
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
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

package javafx.scene.control;

/**
Builder class for javafx.scene.control.ToggleButton
@see javafx.scene.control.ToggleButton
@deprecated This class is deprecated and will be removed in the next version
* @since JavaFX 2.0
*/
@javax.annotation.Generated("Generated by javafx.builder.processor.BuilderProcessor")
@Deprecated
public class ToggleButtonBuilder<B extends javafx.scene.control.ToggleButtonBuilder<B>> extends javafx.scene.control.ButtonBaseBuilder<B> implements javafx.util.Builder<javafx.scene.control.ToggleButton> {
    protected ToggleButtonBuilder() {
    }

    /** Creates a new instance of ToggleButtonBuilder. */
    @SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
    public static javafx.scene.control.ToggleButtonBuilder<?> create() {
        return new javafx.scene.control.ToggleButtonBuilder();
    }

    private int __set;
    public void applyTo(javafx.scene.control.ToggleButton x) {
        super.applyTo(x);
        int set = __set;
        if ((set & (1 << 0)) != 0) x.setSelected(this.selected);
        if ((set & (1 << 1)) != 0) x.setToggleGroup(this.toggleGroup);
    }

    private boolean selected;
    /**
    Set the value of the {@link javafx.scene.control.ToggleButton#isSelected() selected} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B selected(boolean x) {
        this.selected = x;
        __set |= 1 << 0;
        return (B) this;
    }

    private javafx.scene.control.ToggleGroup toggleGroup;
    /**
    Set the value of the {@link javafx.scene.control.ToggleButton#getToggleGroup() toggleGroup} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B toggleGroup(javafx.scene.control.ToggleGroup x) {
        this.toggleGroup = x;
        __set |= 1 << 1;
        return (B) this;
    }

    /**
    Make an instance of {@link javafx.scene.control.ToggleButton} based on the properties set on this builder.
    */
    public javafx.scene.control.ToggleButton build() {
        javafx.scene.control.ToggleButton x = new javafx.scene.control.ToggleButton();
        applyTo(x);
        return x;
    }
}
