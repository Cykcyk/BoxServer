package com.boxserver.BoxServer.charades.slogan.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static com.boxserver.BoxServer.charades.slogan.dao.Slogan.*;

@Transactional
@Service
@SuppressWarnings("unchecked")
public class SloganRepository {

    @Autowired
    private EntityManager entityManager;

    public Optional<Slogan> findById(Long id) {

        Assert.notNull(id, "id must not be null");

        Slogan slogan = (Slogan) getSession().createCriteria(Slogan.class)
                .add(Restrictions.eq(D_ID, id))
                .uniqueResult();

        return Optional.ofNullable(slogan);
    }

    public List<Long> findIdsByCategoriesAndDifficulties(List<SloganCategory> categories, List<SloganDifficulty> difficulties) {

        Criteria criteria = createBasicCriteriaForCategoriesAndDifficulties(categories, difficulties);

        return criteria.setProjection(Projections.distinct(Projections.property(D_ID)))
                .list();
    }

    public List<Long> findDoubleSloganIdsByCategoriesAndDifficulties(List<SloganCategory> categories, List<SloganDifficulty> difficulties) {

        Criteria criteria = createBasicCriteriaForCategoriesAndDifficulties(categories, difficulties);

        criteria.add(Restrictions.isNotNull(D_SECOND_SLOGAN));

        return criteria.setProjection(Projections.distinct(Projections.property(D_ID)))
                .list();
    }

    private Criteria createBasicCriteriaForCategoriesAndDifficulties(List<SloganCategory> categories, List<SloganDifficulty> difficulties) {

        Criteria criteria = getSession().createCriteria(Slogan.class);

        if (categories != null && !categories.isEmpty()) {

            criteria.add(Restrictions.in(D_CATEGORY, categories));
        }

        if (difficulties != null && !difficulties.isEmpty()) {

            criteria.add(Restrictions.in(D_DIFFICULTY, difficulties));
        }
        return criteria;
    }

    public void saveOrUpdate(Slogan slogan) {

        Assert.notNull(slogan, "slogan must not be null");

        getSession().saveOrUpdate(slogan);
    }

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
}
