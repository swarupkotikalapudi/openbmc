SUMMARY = "Phosphor BMC State Management"
DESCRIPTION = "Phosphor BMC State Manager provides a BMC state \
object which manages the BMCs in the system. It is suitable for use on \
a wide variety of OpenBMC platforms."
HOMEPAGE = "https://github.com/openbmc/phosphor-state-manager"
PR = "r1"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"

inherit autotools pkgconfig
inherit obmc-phosphor-dbus-service

DBUS_SERVICE_${PN} += "xyz.openbmc_project.State.BMC.service"

RDEPENDS_${PN} += "libsystemd"
DEPENDS += "autoconf-archive-native"
DEPENDS += "sdbusplus"
DEPENDS += "phosphor-logging"

PROVIDES += "virtual/obmc-bmc-state-mgmt"
RPROVIDES_${PN} += "virtual-obmc-bmc-state-mgmt"

SRC_URI += "git://github.com/openbmc/phosphor-state-manager"
SRCREV = "794baed325213d39d75e5f8c3374177891ef70ec"

S = "${WORKDIR}/git"
