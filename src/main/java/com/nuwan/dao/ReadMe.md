Core Programming Elements for Different Data Access Strategies
--------------------------------------------------------------

Concept     JDBC            Hibernate           JPA
Resource    Connection      Session             EntityManager
Resource    factory         DataSource          SessionFactory EntityManagerFactory
Exception   SQLException    HibernateException  PersistenceException

In Hibernate, the core interface for object persistence is Session, whose instances can be obtained
from a SessionFactory instance. In JPA, the corresponding interface is EntityManager, whose instances
can be obtained from an EntityManagerFactory instance. The exceptions thrown by Hibernate are of type
HibernateException, while those thrown by JPA may be of type PersistenceException or other Java SE exceptions
like IllegalArgumentException and IllegalStateException. Note that all these exceptions are subclasses of
RuntimeException, which you are not forced to catch and handle.

Each application that uses Hibernate requires a global configuration file to configure properties such as the
database settings (either JDBC connection properties or a data source’s JNDI name), the database dialect, the
mapping metadata’s locations, and so on. When using XML mapping files to define mapping metadata, you have
to specify the locations of the XML files. By default, Hibernate will read the hibernate.cfg.xml file from the root of
the classpath. The middle extension cfg stands for “configuration.” If there is a hibernate.properties file on the
classpath, that file will be consulted first and overridden by hibernate.cfg.xml.