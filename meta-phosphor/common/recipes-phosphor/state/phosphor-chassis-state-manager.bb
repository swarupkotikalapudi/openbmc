SUMMARY = "Phosphor Chassis State Management"
DESCRIPTION = "Phosphor Chassis State Manager provides a chassis state \
object which manages the chassis's in the system. It is suitable for use on \
a wide variety of OpenBMC platforms."
HOMEPAGE = "https://github.com/openbmc/phosphor-state-manager"
PR = "r1"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"

inherit autotools pkgconfig
inherit obmc-phosphor-dbus-service

DBUS_SERVICE_${PN} += "xyz.openbmc_project.State.Chassis.service"

RDEPENDS_${PN} += "libsystemd"
DEPENDS += "autoconf-archive-native"
DEPENDS += "sdbusplus"

PROVIDES += "virtual/obmc-chassis-state-mgmt"
RPROVIDES_${PN} += "virtual-obmc-chassis-state-mgmt"

SRC_URI += "git://github.com/openbmc/phosphor-state-manager"
SRCREV = "794baed325213d39d75e5f8c3374177891ef70ec"

S = "${WORKDIR}/git"
