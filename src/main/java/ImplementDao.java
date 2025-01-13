import javax.persistence.*;
import java.util.List;

public class ImplementDao implements DAO {

        private EntityManagerFactory emf;

    public ImplementDao() {
            // Inicializa o EntityManagerFactory
         this.emf = Persistence.createEntityManagerFactory("teste");

    }
    @Override
    public void adicionarUsuario(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(usuario);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public Usuario buscarUsuario(int id) {
        EntityManager em = emf.createEntityManager();
        try {
           return em.find(Usuario.class, id);
            } finally {
            em.close();
        }
        }

    @Override
    public List<Usuario> listarUsuarios() {
        EntityManager em = emf.createEntityManager();
        try  {
            return em.createQuery("from Usuario").getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void atualizarUsuario(Usuario selectNome) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = null;
        try  {
            transaction = em.getTransaction();
            transaction.begin();
            em.merge(selectNome);
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void removerUsuario(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            Usuario usuario = em.find(Usuario.class, id);
            if (usuario != null) {
                em.remove(usuario);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    }