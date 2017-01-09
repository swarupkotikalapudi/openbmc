SUMMARY = "Phosphor LED group manager"
DESCRIPTION = "Daemon to cater to triggering actions on LED groups"
HOMEPAGE = "http://github.com/openbmc/phosphor-led-manager"
PR = "r1"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"
inherit pythonnative
inherit autotools pkgconfig
inherit obmc-phosphor-python-autotools

DEPENDS += "python-pyyaml-native"
DEPENDS += "autoconf-archive-native"
DEPENDS += "sdbusplus sdbusplus-native"
DEPENDS += "systemd"
RDEPENDS_${PN} += "libsystemd"
PROVIDES += "virtual/obmc-led-group-mgmt"
RPROVIDES_${PN} += "virtual-obmc-led-group-mgmt"
RRECOMMENDS_${PN} += "virtual-obmc-led-controller"

#SRC_URI += "git://github.com/openbmc/phosphor-led-manager"
SRC_URI += "git:///home/OpenBmc/led-manager"
SRCREV = "98691fa88d107a1649847b032f1a9b1218061324"
S = "${WORKDIR}/git"

DBUS_SERVICE_${PN} += "xyz.openbmc_project.ledmanager.service"
