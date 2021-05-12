import java.awt.*;

public class MyLayout extends FlowLayout implements LayoutManager {
    @Override
    public void addLayoutComponent(String name, Component comp) {
    }

    @Override
    public void removeLayoutComponent(Component comp) {
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return null;
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return null;
    }

    @Override
    public void layoutContainer(Container parent) {
        int countOfComponent = 0;
        int x = 20;
        int y = 0;
        int column = 9;

        for (int i = 0; i < parent.getComponentCount(); i++) {
            Component component = parent.getComponent(i);
            component.setBounds(x, y * 30, 45, 20);
            countOfComponent++;
            y++;
            if (countOfComponent > column) {
                x += 50;
                column += 10;
                y = 0;
            }
        }
    }
}

