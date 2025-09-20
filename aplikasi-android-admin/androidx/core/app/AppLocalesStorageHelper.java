package androidx.core.app;

public class AppLocalesStorageHelper {
    static final String APPLICATION_LOCALES_RECORD_FILE = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file";
    static final boolean DEBUG = false;
    static final String LOCALE_RECORD_ATTRIBUTE_TAG = "application_locales";
    static final String LOCALE_RECORD_FILE_TAG = "locales";
    static final String TAG = "AppLocalesStorageHelper";
    private static final Object sAppLocaleStorageSync = new Object();

    private AppLocalesStorageHelper() {
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:33:0x0060=Splitter:B:33:0x0060, B:44:0x0076=Splitter:B:44:0x0076} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String readLocales(android.content.Context r9) {
        /*
            java.lang.Object r0 = sAppLocaleStorageSync
            monitor-enter(r0)
            java.lang.String r1 = ""
            java.lang.String r2 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            java.io.FileInputStream r2 = r9.openFileInput(r2)     // Catch:{ FileNotFoundException -> 0x0077 }
            org.xmlpull.v1.XmlPullParser r3 = android.util.Xml.newPullParser()     // Catch:{ IOException | XmlPullParserException -> 0x0051 }
            java.lang.String r4 = "UTF-8"
            r3.setInput(r2, r4)     // Catch:{ IOException | XmlPullParserException -> 0x0051 }
            int r4 = r3.getDepth()     // Catch:{ IOException | XmlPullParserException -> 0x0051 }
        L_0x0019:
            int r5 = r3.next()     // Catch:{ IOException | XmlPullParserException -> 0x0051 }
            r6 = r5
            r7 = 1
            if (r5 == r7) goto L_0x0047
            r5 = 3
            if (r6 != r5) goto L_0x002a
            int r7 = r3.getDepth()     // Catch:{ IOException | XmlPullParserException -> 0x0051 }
            if (r7 <= r4) goto L_0x0047
        L_0x002a:
            if (r6 == r5) goto L_0x0019
            r5 = 4
            if (r6 != r5) goto L_0x0030
            goto L_0x0019
        L_0x0030:
            java.lang.String r5 = r3.getName()     // Catch:{ IOException | XmlPullParserException -> 0x0051 }
            java.lang.String r7 = "locales"
            boolean r7 = r5.equals(r7)     // Catch:{ IOException | XmlPullParserException -> 0x0051 }
            if (r7 == 0) goto L_0x0046
            java.lang.String r7 = "application_locales"
            r8 = 0
            java.lang.String r7 = r3.getAttributeValue(r8, r7)     // Catch:{ IOException | XmlPullParserException -> 0x0051 }
            r1 = r7
            goto L_0x0047
        L_0x0046:
            goto L_0x0019
        L_0x0047:
            if (r2 == 0) goto L_0x0060
            r2.close()     // Catch:{ IOException -> 0x004d }
        L_0x004c:
            goto L_0x0060
        L_0x004d:
            r3 = move-exception
            goto L_0x004c
        L_0x004f:
            r3 = move-exception
            goto L_0x006e
        L_0x0051:
            r3 = move-exception
            java.lang.String r4 = "AppLocalesStorageHelper"
            java.lang.String r5 = "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            android.util.Log.w(r4, r5)     // Catch:{ all -> 0x004f }
            if (r2 == 0) goto L_0x0060
            r2.close()     // Catch:{ IOException -> 0x004d }
            goto L_0x004c
        L_0x0060:
            boolean r3 = r1.isEmpty()     // Catch:{ all -> 0x007a }
            if (r3 != 0) goto L_0x0067
            goto L_0x006c
        L_0x0067:
            java.lang.String r3 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            r9.deleteFile(r3)     // Catch:{ all -> 0x007a }
        L_0x006c:
            monitor-exit(r0)     // Catch:{ all -> 0x007a }
            return r1
        L_0x006e:
            if (r2 == 0) goto L_0x0075
            r2.close()     // Catch:{ IOException -> 0x0074 }
            goto L_0x0075
        L_0x0074:
            r4 = move-exception
        L_0x0075:
            throw r3     // Catch:{ all -> 0x007a }
        L_0x0077:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x007a }
            return r1
        L_0x007a:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x007a }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.AppLocalesStorageHelper.readLocales(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:36:0x0063=Splitter:B:36:0x0063, B:29:0x0059=Splitter:B:29:0x0059} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void persistLocales(android.content.Context r7, java.lang.String r8) {
        /*
            java.lang.Object r0 = sAppLocaleStorageSync
            monitor-enter(r0)
            java.lang.String r1 = ""
            boolean r1 = r8.equals(r1)     // Catch:{ all -> 0x0078 }
            if (r1 == 0) goto L_0x0012
            java.lang.String r1 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            r7.deleteFile(r1)     // Catch:{ all -> 0x0078 }
            monitor-exit(r0)     // Catch:{ all -> 0x0078 }
            return
        L_0x0012:
            r1 = 1
            r2 = 0
            java.lang.String r3 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            java.io.FileOutputStream r2 = r7.openFileOutput(r3, r2)     // Catch:{ FileNotFoundException -> 0x0064 }
            org.xmlpull.v1.XmlSerializer r3 = android.util.Xml.newSerializer()     // Catch:{ all -> 0x0078 }
            r4 = 0
            r3.setOutput(r2, r4)     // Catch:{ Exception -> 0x0048 }
            java.lang.String r5 = "UTF-8"
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ Exception -> 0x0048 }
            r3.startDocument(r5, r1)     // Catch:{ Exception -> 0x0048 }
            java.lang.String r1 = "locales"
            r3.startTag(r4, r1)     // Catch:{ Exception -> 0x0048 }
            java.lang.String r1 = "application_locales"
            r3.attribute(r4, r1, r8)     // Catch:{ Exception -> 0x0048 }
            java.lang.String r1 = "locales"
            r3.endTag(r4, r1)     // Catch:{ Exception -> 0x0048 }
            r3.endDocument()     // Catch:{ Exception -> 0x0048 }
            if (r2 == 0) goto L_0x0059
            r2.close()     // Catch:{ IOException -> 0x0057 }
            goto L_0x0056
        L_0x0046:
            r1 = move-exception
            goto L_0x005b
        L_0x0048:
            r1 = move-exception
            java.lang.String r4 = "AppLocalesStorageHelper"
            java.lang.String r5 = "Storing App Locales : Failed to persist app-locales in storage "
            android.util.Log.w(r4, r5, r1)     // Catch:{ all -> 0x0046 }
            if (r2 == 0) goto L_0x0059
            r2.close()     // Catch:{ IOException -> 0x0057 }
        L_0x0056:
            goto L_0x0059
        L_0x0057:
            r1 = move-exception
            goto L_0x0056
        L_0x0059:
            monitor-exit(r0)     // Catch:{ all -> 0x0078 }
            return
        L_0x005b:
            if (r2 == 0) goto L_0x0062
            r2.close()     // Catch:{ IOException -> 0x0061 }
            goto L_0x0062
        L_0x0061:
            r4 = move-exception
        L_0x0062:
            throw r1     // Catch:{ all -> 0x0078 }
        L_0x0064:
            r3 = move-exception
            java.lang.String r4 = "AppLocalesStorageHelper"
            java.lang.String r5 = "Storing App Locales : FileNotFoundException: Cannot open file %s for writing "
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0078 }
            java.lang.String r6 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            r1[r2] = r6     // Catch:{ all -> 0x0078 }
            java.lang.String r1 = java.lang.String.format(r5, r1)     // Catch:{ all -> 0x0078 }
            android.util.Log.w(r4, r1)     // Catch:{ all -> 0x0078 }
            monitor-exit(r0)     // Catch:{ all -> 0x0078 }
            return
        L_0x0078:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0078 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.AppLocalesStorageHelper.persistLocales(android.content.Context, java.lang.String):void");
    }
}
