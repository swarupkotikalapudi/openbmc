SUMMARY = "Parser for OpenPOWER-format FRU VPD"
DESCRIPTION = "Parse OpenPOWER-format FRU VPD and update inventory"
PR = "r1"

inherit autotools pkgconfig
inherit openpower-fru-vpd
inherit pythonnative
inherit obmc-phosphor-systemd

require ${PN}.inc

SRC_URI += "file://70-op-vpd.rules"

DEPENDS += " \
        virtual/openpower-fru-vpd-layout \
        virtual/openpower-fru-inventory \
        virtual/openpower-fru-properties \
        python-mako-native \
        python-pyyaml-native \
        phosphor-mapper \
        sdbusplus \
        phosphor-logging \
        autoconf-archive-native \
        "

RDEPENDS_${PN} += "libsystemd"

SYSTEMD_SERVICE_${PN} += "op-vpd-parser.service"

S = "${WORKDIR}/git"

EXTRA_OECONF = " \
             FRU_YAML=${STAGING_DIR_NATIVE}${vpdlayout_datadir}/layout.yaml \
             PROP_YAML=${STAGING_DIR_NATIVE}${properties_datadir}/out.yaml \
             "

do_install_append() {
        SRC=${STAGING_DATADIR_NATIVE}${inventory_datadir_name}
        DEST=${D}${inventory_envdir}
        install -d ${DEST}
        install ${SRC}/inventory ${DEST}

        install -d ${D}/${base_libdir}/udev/rules.d/
        install ${WORKDIR}/70-op-vpd.rules ${D}/${base_libdir}/udev/rules.d/
}
