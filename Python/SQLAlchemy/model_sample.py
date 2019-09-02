import re

import inflect
from sqlalchemy import create_engine, MetaData
from sqlalchemy.ext.automap import automap_base
from sqlalchemy.orm import Session

_inflector = inflect.engine()


def standardize_class_name(base, tablename, table):
    """
    Produce a class name in PascalCase and singular, e.g. 'my_entities' -> 'MyEntity'

    :param base:
    :param tablename:
    :param table:
    :return:
    """

    return _inflector.singular_noun(tablename[0].upper() +
               re.sub(r'_([a-z])', lambda m: m.group(1).upper(), tablename[1:]))


def standardize_collection_name(base, local_cls, referred_cls, constraint):
    """
    Produce a collection name in snake_case and plural, e.g. "'SomeTerm' -> 'some_terms'"

    :param base:
    :param local_cls:
    :param referred_cls:
    :param constraint:
    :return:
    """

    return _inflector.plural(re.sub(r'[A-Z]',
                                    lambda m: "_%s" % m.group(0).lower(),
                                    referred_cls.__name__)[1:])


if environ.get('PGUSER') and environ.get('PGPASSWORD') and environ.get('PGHOST') and environ.get('PGPORT') and \
        environ.get('PGDATABASE'):
    engine = create_engine('postgresql+psycopg2://{}:{}@{}:{}/{}'.format(
        environ.get('PGUSER'), environ.get('PGPASSWORD'), environ.get('PGHOST'), environ.get('PGPORT'),
        environ.get('PGDATABASE')), echo=True)
else:
    engine = create_engine('postgresql+psycopg2://@/{}'.format(environ.get('PGDATABASE')), echo=True)

print "Getting metadata for the public schema..."
metadata = MetaData()
# We can reflect metadata from a database, using options such as 'only' to limit what tables we look at
metadata.reflect(engine, schema="public", only=['derwent_patents', 'wos_publications'])
# We can then produce a set of mappings from this MetaData
Base = automap_base(metadata=metadata)
# Calling prepare() just sets up mapped classes and relationships
Base.prepare(classname_for_table=standardize_class_name, name_for_collection_relationship=standardize_collection_name)
# Base.prepare(engine, reflect=True, schema="public", classname_for_table=camelize_classname,
# name_for_collection_relationship=pluralize_collection)
print "Metadata is retrieved..."

# mapped classes are now created with names by default matching that of the table name.
# DerwentPatent = Base.classes.derwent_patents
# WosPublication = Base.classes.wos_publications

session = Session(engine)

derwent_patent = session.query(Base.classes.DerwentPatent) \
    .filter_by(patent_num_orig='06829994', patent_type='B2').first()
print "{} {}".format(derwent_patent.__class__, derwent_patent.__dict__)

# wos_publication = session.query(WosPublication).filter_by(source_id='ed').first()
# print wos_publication
