<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fp="http://functionpro.com/schema/xi" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:xdt="http://www.w3.org/2005/xpath-datatypes">
    <xsl:output version="1.0" encoding="ISO-8859-1" indent="no" method="text" omit-xml-declaration="yes" media-type="text/rtf" />
    <xsl:template match="/">
        <xsl:param name="tablewidth" select="10511" />
        <xsl:param name="globaltablelevel" select="0" />
        <xsl:text>{\rtf1\ansi\ansicpg65001\deff0</xsl:text>
        <xsl:text>{\fonttbl{\f0\fnil Times New Roman;}{\f1\fnil Arial;}{\f2\fnil Symbol;}{\f3\fnil Wingdings;}}</xsl:text>
        <xsl:text>{\colortbl;\red255\green255\blue255;\red0\green0\blue255;}</xsl:text>
        <xsl:text>{\stylesheet{\ql \fs24 \snext0 Normal;}{\s1\ql \b\f1\fs48 \snext0 Heading 1;}{\s2\ql \b\f1\fs36 \snext0 Heading 2;}{\s3\ql \b\f1\fs28 \snext0 Heading 3;}{\s4\ql \b\f1\fs24 \snext0 Heading 4;}{\s5\ql \b\f1\fs20 \snext0 Heading 5;}{\s6\ql \b\f1\fs16 \snext0 Heading 6;}{\s7\ql \i\f0\fs24 \snext0 Address;}{\s8\ql \lin720\f0\fs24 \snext0 Blockquote;}{\s9\qc \f0\fs24 \snext0 Center;}}</xsl:text>
        <xsl:text>{\*\generator Altova-Stylevision-2005;}\viewkind1\viewzk2\viewscale75\paperh15840 \paperw12240 \margt1137 \margb1137 \margr864 \margl864 \uc1\pard\fs24</xsl:text>
        <xsl:text>\pard</xsl:text>
        <xsl:if test="$globaltablelevel + 0 = 1">
            <xsl:text>\intbl</xsl:text>
        </xsl:if>
        <xsl:if test="$globaltablelevel + 0 > 1">
            <xsl:text>\itap</xsl:text>
            <xsl:value-of select="$globaltablelevel + 0" />
        </xsl:if>
        <xsl:text>{</xsl:text>
        <xsl:apply-templates />
        <xsl:text>}</xsl:text>
        <xsl:text>}</xsl:text>
    </xsl:template>
    <xsl:template match="fp:XI">
        <xsl:param name="tablewidth" select="10511" />
        <xsl:param name="globaltablelevel" select="0" />
        <xsl:text>\pard\s1\ql \b\f1\fs48 </xsl:text>
        <xsl:if test="$globaltablelevel + 0 = 1">
            <xsl:text>\intbl</xsl:text>
        </xsl:if>
        <xsl:if test="$globaltablelevel + 0 > 1">
            <xsl:text>\itap</xsl:text>
            <xsl:value-of select="$globaltablelevel + 0" />
        </xsl:if>
        <xsl:text>{\par}</xsl:text><xsl:text>\pard\s1\ql \b\f1\fs48 </xsl:text>
        <xsl:if test="$globaltablelevel + 0 = 1">
            <xsl:text>\intbl</xsl:text>
        </xsl:if>
        <xsl:if test="$globaltablelevel + 0 > 1">
            <xsl:text>\itap</xsl:text>
            <xsl:value-of select="$globaltablelevel + 0" />
        </xsl:if>
        <xsl:text>{</xsl:text>
        <xsl:call-template name="write-text">
            <xsl:with-param name="text">
                <xsl:text>XI version </xsl:text>
            </xsl:with-param>
        </xsl:call-template>
        <xsl:text>}</xsl:text>
        <xsl:for-each select="@version">
            <xsl:text>\pard\s1\ql \b\f1\fs48 </xsl:text>
            <xsl:if test="$globaltablelevel + 0 = 1">
                <xsl:text>\intbl</xsl:text>
            </xsl:if>
            <xsl:if test="$globaltablelevel + 0 > 1">
                <xsl:text>\itap</xsl:text>
                <xsl:value-of select="$globaltablelevel + 0" />
            </xsl:if>
            <xsl:text>{</xsl:text>
            <xsl:call-template name="write-text">
                <xsl:with-param name="text">
                    <xsl:value-of select="." />
                </xsl:with-param>
            </xsl:call-template>
            <xsl:text>}</xsl:text>
        </xsl:for-each>
        <xsl:text>\pard\s1\ql \b\f1\fs48 </xsl:text>
        <xsl:if test="$globaltablelevel + 0 = 1">
            <xsl:text>\intbl</xsl:text>
        </xsl:if>
        <xsl:if test="$globaltablelevel + 0 > 1">
            <xsl:text>\itap</xsl:text>
            <xsl:value-of select="$globaltablelevel + 0" />
        </xsl:if>
        <xsl:text>{\par}</xsl:text>\pard\s0\ql \b0\f0\fs24 </xsl:template>
	<xsl:template name="write-text">
		<xsl:param name="text"/>
		<xsl:variable name="txt" select="string-join($text,'')"/>
			<xsl:value-of select="string-join(for $i in string-to-codepoints($txt) return if ($i &lt; 32) then ' ' else concat('\u',string($i),'?'),'')"/>
	</xsl:template>
	<xsl:template match="text() |@*">
		<xsl:call-template name="write-text">
			<xsl:with-param name="text" select="."/>
		</xsl:call-template>
	</xsl:template>
</xsl:stylesheet>
