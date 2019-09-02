<?xml version="1.0" encoding="UTF-8"?>
<structure version="3" schemafile="XI.xsd" workingxmlfile="learn.learning.xml" templatexmlfile="" xsltversion="2" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8">
	<nspair prefix="fp" uri="http://functionpro.com/schema/xi"/>
	<nspair prefix="xs" uri="http://www.w3.org/2001/XMLSchema"/>
	<template>
		<match overwrittenxslmatch="/"/>
		<children>
			<xpath allchildren="1"/>
		</children>
	</template>
	<template>
		<match match="fp:XI"/>
		<children>
			<paragraph paragraphtag="h1">
				<children>
					<text fixtext="XI version "/>
					<template>
						<match match="@version"/>
						<children>
							<xpath allchildren="1"/>
						</children>
					</template>
				</children>
			</paragraph>
			<newline/>
			<xpath restofcontents="1"/>
			<newline/>
		</children>
	</template>
	<template>
		<match match="fp:attribute"/>
		<children>
			<xpath allchildren="1"/>
		</children>
	</template>
	<template>
		<match match="fp:domain"/>
		<children>
			<paragraph paragraphtag="h2">
				<children>
					<text fixtext="Domain "/>
					<template>
						<match match="@name"/>
						<children>
							<xpath allchildren="1"/>
						</children>
					</template>
					<text fixtext=", version = "/>
					<template>
						<match match="@version"/>
						<children>
							<xpath allchildren="1"/>
						</children>
					</template>
				</children>
			</paragraph>
			<newline/>
			<xpath restofcontents="1"/>
			<newline/>
		</children>
	</template>
	<pagelayout>
		<properties pagemultiplepages="0" pagenumberingformat="1" pagenumberingstartat="1" paperheight="11in" papermarginbottom="0.79in" papermarginleft="0.6in" papermarginright="0.6in" papermargintop="0.79in" paperwidth="8.5in"/>
	</pagelayout>
</structure>
