package repository;

import model.RutaBus;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaRutaBusRepository implements RutaBusRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("RutaBusPU");

    @Override
    public void create(RutaBus rutaBus) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(rutaBus);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public RutaBus read(int id) {
        EntityManager em = emf.createEntityManager();
        RutaBus rutaBus = em.find(RutaBus.class, id);
        em.close();
        return rutaBus;
    }

    @Override
    public List<RutaBus> readAll() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<RutaBus> query = em.createQuery("SELECT r FROM RutaBus r", RutaBus.class);
        List<RutaBus> rutas = query.getResultList();
        em.close();
        return rutas;
    }

    @Override
    public void update(RutaBus rutaBus) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(rutaBus);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        RutaBus rutaBus = em.find(RutaBus.class, id);
        if (rutaBus != null) {
            em.remove(rutaBus);
        }
        em.getTransaction().commit();
        em.close();
    }
}
