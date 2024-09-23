import java.util.HashSet;
import java.util.Set;

public class VennDiagram<T extends Comparable<T>> {
    private String label1, label2, label3;
    private Set<T> circle1;
    private Set<T> circle2;
    private Set<T> circle3;

    public VennDiagram(String label1, String label2, String label3) {
        this.label1 = label1;
        this.label2 = label2;
        this.label3 = label3;
        this.circle1 = new HashSet<>();
        this.circle2 = new HashSet<>();
        this.circle3 = new HashSet<>();
    }

    private Set<T> getCircleForLabel(String label) {
        if (label.equals(label1)) {
            return circle1;
        } else if (label.equals(label2)) {
            return circle2;
        } else if (label.equals(label3)) {
            return circle3;
        } else {
            throw new IllegalArgumentException("Unknown label: " + label);
        }
    }

    public void add(T item, String... labels) {
        for (String label : labels) {
            getCircleForLabel(label).add(item);
        }
    }

    public Set<T> unionOf(String first, String second) {
        Set<T> result = new HashSet<>(getCircleForLabel(first));
        result.addAll(getCircleForLabel(second));
        return result;
    }

    public Set<T> intersectionOf(String first, String second) {
        Set<T> result = new HashSet<>(getCircleForLabel(first));
        result.retainAll(getCircleForLabel(second));
        return result;
    }

    public Set<T> complementOf(String first, String second) {
        Set<T> result = new HashSet<>(getCircleForLabel(first));
        result.removeAll(getCircleForLabel(second));
        return result;
    }

    public Set<T> diagramCenter() {
        Set<T> result = new HashSet<>(circle1);
        result.retainAll(circle2);
        result.retainAll(circle3);
        return result;
    }

    public Set<T> getSet(String label) {
        return getCircleForLabel(label);
    }
}
