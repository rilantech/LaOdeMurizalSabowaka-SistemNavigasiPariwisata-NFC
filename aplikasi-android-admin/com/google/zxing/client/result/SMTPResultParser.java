package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class SMTPResultParser extends ResultParser {
    public EmailAddressParsedResult parse(Result result) {
        String body;
        String subject;
        String massagedText = getMassagedText(result);
        String rawText = massagedText;
        if (!massagedText.startsWith("smtp:") && !rawText.startsWith("SMTP:")) {
            return null;
        }
        String emailAddress = rawText.substring(5);
        int indexOf = emailAddress.indexOf(58);
        int colon = indexOf;
        if (indexOf >= 0) {
            String subject2 = emailAddress.substring(colon + 1);
            emailAddress = emailAddress.substring(0, colon);
            int indexOf2 = subject2.indexOf(58);
            int colon2 = indexOf2;
            if (indexOf2 >= 0) {
                String body2 = subject2.substring(colon2 + 1);
                subject = subject2.substring(0, colon2);
                body = body2;
                int i = colon2;
            } else {
                subject = subject2;
                body = null;
                int i2 = colon2;
            }
        } else {
            subject = null;
            body = null;
            int i3 = colon;
        }
        return new EmailAddressParsedResult(new String[]{emailAddress}, (String[]) null, (String[]) null, subject, body);
    }
}
