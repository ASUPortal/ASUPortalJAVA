/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ac.ugatu.asu.core.tags;

import javax.servlet.jsp.JspWriter;
import org.springframework.web.servlet.tags.RequestContextAwareTag;
import ru.ac.ugatu.asu.setting.Setting;
import ru.ac.ugatu.asu.setting.SettingService;

/**
 *
 * @author aleksandr
 */
public class settingStringValue extends RequestContextAwareTag {
    private String settingsAlias;
    private SettingService settingService;

    public SettingService getSettingService() {
        if (this.settingService == null) {
            this.settingService = getRequestContext().getWebApplicationContext().getBean(SettingService.class);
        }
        return settingService;
    }

    public void setSettingsAlias(String settingsAlias) {
        this.settingsAlias = settingsAlias;
    }

    public String getSettingsAlias() {
        return settingsAlias;
    }
    
    @Override
    protected int doStartTagInternal() throws Exception {
        JspWriter out = this.pageContext.getOut();
        Setting setting = this.getSettingService().getSetting(this.getSettingsAlias());
        if (setting != null) {
            out.print(setting.getValue());
        }
        return RequestContextAwareTag.EVAL_BODY_INCLUDE;
    }
    
}
