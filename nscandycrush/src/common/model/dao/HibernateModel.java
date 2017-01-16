package common.model.dao;

import java.io.Serializable;

import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;
import javax.persistence.InheritanceType;

@MappedSuperclass @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class HibernateModel
{
    
}
