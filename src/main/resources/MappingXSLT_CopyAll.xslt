<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <!--Identity template,
            provides default behavior that copies all content into the output
            Kjekt å bruke ved migrering mellom nesten identiske XSD'er-->
    <xsl:template match="@*|node()">
        <xsl:copy>
            <xsl:apply-templates select="@*|node()"/>
        </xsl:copy>
    </xsl:template>

    <!--Miniendring. Set organisasjonsnummer til ORG<nr> -->
    <xsl:template match="organisasjonsnummer">
        <xsl:copy>
            <xsl:apply-templates select="@*|node()"/>
            <!--Do something special for Node766, like add a certain string-->
            <xsl:text> "Dummy" </xsl:text>
        </xsl:copy>
    </xsl:template>

</xsl:stylesheet>