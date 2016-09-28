SUMMARY = "Phosphor OpenBMC OEM Commands for OpenPOWER systems"
DESCRIPTION = "Phosphor OpenBMC IPMI OEM commands for OpenPOWER based systems"
HOMEPAGE = "https://github.com/openbmc/openpower-host-ipmi-oem"
PR = "r1"

inherit autotools pkgconfig
inherit obmc-phosphor-license

DEPENDS += "host-ipmid"
DEPENDS += "autoconf-archive-native"

TARGET_CFLAGS += "-fpic"

SRC_URI += "git://github.com/openbmc/openpower-host-ipmi-oem"
SRCREV = "afcd083ec0abddaf4efa51030a2ecc1189b90f28"

S = "${WORKDIR}/git"

FILES_${PN}_append = " ${libdir}/host-ipmid/lib*${SOLIBS}"
FILES_${PN}-dev_append = " ${libdir}/host-ipmid/lib*${SOLIBSDEV} ${libdir}/host-ipmid/*.la"
