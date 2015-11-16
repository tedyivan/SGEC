package mz.gov.sgec.controller;

import org.zkoss.zul.Listheader;

public class My extends Listheader {
    @Override
    protected void updateByClient(String name, Object value) {
        if("visible".equals(name)) {
            this.setVisible((Boolean)value);
        } else {
            super.updateByClient(name, value);
        }
    }
}