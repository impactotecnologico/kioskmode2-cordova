#!/usr/bin/env sh

echo ${0:h}

MANIFEST=${0:h}/../../platforms/android/app/src/main/AndroidManifest.xml
[[ -e $MANIFEST ]] || { print "Manifest not found at $MANIFEST." ; exit 1; }

AFTER_LINE='launcher_name'
ADDITION='\
        <category android:name="android.intent.category.DEFAULT" />\
        <category android:name="android.intent.category.HOME" />
';

sed -i -e "/${AFTER_LINE}/a${ADDITION}" $MANIFEST