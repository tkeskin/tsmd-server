package tr.com.tsmd.cengiz.util;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

public class StringPrefixedSequenceIdGenerator extends SequenceStyleGenerator {

  private String format;
  private String prefix;
  private final static String degerler="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
  SecureRandom karistirici = new SecureRandom();

  @Override
  public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
    System.out.println("generate="+this.format);
    StringBuilder rastgeleDegerYapici = new StringBuilder(4);
    for (int i =0; i<4; i++){
      rastgeleDegerYapici.append(degerler.charAt(karistirici.nextInt(degerler.length())));
    }
    this.format= (new Date().getYear()+1900)+"-"+prefix+"-"+rastgeleDegerYapici.toString();
    System.out.println("generate");
    return format;
  }

  @Override
  public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
    super.configure(type, params, serviceRegistry);
    prefix = params.getProperty("prefix");
  }
}
