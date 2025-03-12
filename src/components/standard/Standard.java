package components.standard;

/**
 * Standard interface for OSU component design.
 *
 * @param <T>
 *            The type of the component
 */
public interface Standard<T> {
    /**
     * Returns a new instance of this type.
     *
     * @return new instance of the component
     */
    T newInstance();
}
