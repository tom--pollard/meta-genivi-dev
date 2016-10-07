# Copyright (C) 2015-2016 GENIVI Alliance
# Released under the MIT license (see COPYING.MIT for the terms)

LICENSE  = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9741c346eef56131163e13b9db1241b3"
SRC_URI = "git://github.com/GENIVI/connected-home"
SRCREV  = "b7ab6c2cbfed59392b968ec99f1563cbfb81bf36"

SUMMARY = "Connected Home"
DEPENDS = "qtbase qtdeclarative"

SRC_URI_append ="\
    file://connectedhome.service \
    file://connectedhome.app \
    "

S = "${WORKDIR}/git"

inherit qmake5

do_install_append() {
	install -d ${D}${libdir}/systemd/user
	install -m 0444 ${WORKDIR}/connectedhome.service \
	                ${D}${libdir}/systemd/user
     install -d ${D}/usr/share/applications/
     install -m 0444 ${WORKDIR}/connectedhome.app \
                ${D}/usr/share/applications                       
}

FILES_${PN} += "\
    ${libdir}/systemd/user/* \
    "
