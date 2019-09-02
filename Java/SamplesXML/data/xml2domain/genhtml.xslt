<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fp="http://functionpro.com/schema/xi" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:xdt="http://www.w3.org/2005/xpath-datatypes">
    <xsl:output version="1.0" encoding="UTF-8" indent="no" omit-xml-declaration="no" media-type="text/html" />
    <xsl:template match="/">
        <html>
            <head>
                <title />
            </head>
            <body>
                <xsl:apply-templates />
            </body>
        </html>
    </xsl:template>
    <xsl:template match="fp:XI">
        <h1>XI version <xsl:for-each select="@version">
                <xsl:value-of select="." />
            </xsl:for-each>
        </h1>
        <br />
        <xsl:apply-templates select="fp:domain | text()" />
        <br />
    </xsl:template>
    <xsl:template match="fp:attribute">
        <xsl:apply-templates />
    </xsl:template>
    <xsl:template match="fp:domain">
        <h2>Domain <xsl:for-each select="@name">
                <xsl:value-of select="." />
            </xsl:for-each>, version = <xsl:for-each select="@version">
                <xsl:value-of select="." />
            </xsl:for-each>
        </h2>
        <br />
        <xsl:apply-templates select="fp:artifacts | fp:header | fp:processes | text()" />
        <br />
    </xsl:template>
</xsl:stylesheet>
