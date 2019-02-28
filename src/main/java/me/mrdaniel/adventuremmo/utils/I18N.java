package me.mrdaniel.adventuremmo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18N {
    private static Logger logger = LoggerFactory.getLogger("AdventureMMO");
    private static I18N ins = null;
    private ResourceBundle rb;

    private I18N(Locale locale) {
        String resource = "i18n";
        this.rb = ResourceBundle.getBundle(resource, locale);
    }

    static public I18N getInstance() {
        if (ins == null) {
            ins = new I18N(Locale.getDefault());
        }
        return ins;
    }

    static public void setLocale(Locale locale) {
        logger.info("Set language to {}", locale.toLanguageTag());
        ins = new I18N(locale);
    }

    public static String get(String key) {
        return getInstance().rb.getString(key);
    }

}
