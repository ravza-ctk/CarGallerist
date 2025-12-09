package com.rvzctk.gallerist.trigger;


import com.rvzctk.gallerist.model.BaseEntity;
import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Date;

public class BaseEntityListener {

    private static final Logger logger = LoggerFactory.getLogger(BaseEntityListener.class);

    @PrePersist
    public void beforeSave(Object entity) {
        if (entity instanceof BaseEntity baseEntity) {
            baseEntity.setCreatedDate(new Date());
            baseEntity.setUpdatedDate(new Date());
            baseEntity.setCreatedBy("SYSTEM"); // buraya giriş yapan kullanıcıyı set edebilirsin
            logger.info("Yeni kayıt oluşturuluyor: ", entity.getClass().getSimpleName());
        }
    }

    @PreUpdate
    public void beforeUpdate(Object entity) {
        if (entity instanceof BaseEntity baseEntity) {
            baseEntity.setUpdatedDate(new Date());
            baseEntity.setUpdatedBy("SYSTEM");
            logger.info("Kayıt güncelleniyor: ", entity.getClass().getSimpleName());
        }
    }

    @PreRemove
    public void beforeDelete(Object entity) {
        if (entity instanceof BaseEntity baseEntity) {
            baseEntity.setDeletedBy("SYSTEM");
            logger.info("Kayıt siliniyor: ", entity.getClass().getSimpleName());
        }
    }

    @PostPersist
    public void afterSave(Object entity) {
        logger.info("Kayıt eklendi: ", entity.getClass().getSimpleName());
    }

    @PostUpdate
    public void afterUpdate(Object entity) {
        logger.info("Kayıt güncellendi: ", entity.getClass().getSimpleName());
    }

    @PostRemove
    public void afterDelete(Object entity) {
        logger.info("Kayıt silindi: ", entity.getClass().getSimpleName());
    }
}
