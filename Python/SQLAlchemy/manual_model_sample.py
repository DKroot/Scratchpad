from sqlalchemy import create_engine, Column, Integer, String
from sqlalchemy.orm import sessionmaker
from sqlalchemy.ext.declarative import declarative_base

if environ.get('PGUSER') and environ.get('PGPASSWORD') and environ.get('PGHOST') and environ.get('PGPORT') and \
        environ.get('PGDATABASE'):
    engine = create_engine('postgresql+psycopg2://{}:{}@{}:{}/{}'.format(
        environ.get('PGUSER'), environ.get('PGPASSWORD'), environ.get('PGHOST'), environ.get('PGPORT'),
        environ.get('PGDATABASE')), echo=True)
else:
    engine = create_engine('postgresql+psycopg2://@/{}'.format(environ.get('PGDATABASE')), echo=True)
Base = declarative_base()


class DerwentPatent(Base):
    __tablename__ = 'derwent_patents'
    patent_num_orig = Column(String(30), primary_key=True)
    patent_type = Column(String(20), primary_key=True)
    invention_title = Column(String(1000))

    def __str__(self):
        return "{} {}".format(self.__class__, self.__dict__)


class WosPublication(Base):
    __tablename__ = 'wos_publications'
    source_id = Column(Integer, primary_key=True)
    document_title = Column(String(2000))

    def __str__(self):
        return "{} {}".format(self.__class__, self.__dict__)


Session = sessionmaker(bind=engine)
session = Session()
print "Connected."

derwent_patent = session.query(DerwentPatent).filter_by(patent_num_orig='06829994', patent_type='B2').first()
print derwent_patent

# wos_publication = session.query(WosPublication).filter_by(source_id='ed').first()
# print wos_publication
