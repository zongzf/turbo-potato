package com.mybook.mybook.personal.domain;

import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class CommonEntity extends AbstractPersistable<Long> implements DominEntity {

    public void setId(Long id) {
        super.setId(id);
    }

}
