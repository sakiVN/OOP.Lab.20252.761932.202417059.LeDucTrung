package hust.soict.hedspi.aims.screen;

import java.awt.*;

import javax.swing.*;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

public class MediaStore extends JPanel {

    private Media media;
    private Cart cart;

    public MediaStore(Media media, Cart cart) {

        this.media = media;
        this.cart = cart;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());

        title.setFont(new Font(
                title.getFont().getName(),
                Font.PLAIN,
                15
        ));

        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(
                media.getCost() + " $"
        );

        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();

        container.setLayout(
                new FlowLayout(FlowLayout.CENTER)
        );

        JButton addToCartButton =
                new JButton("Add to cart");
        addToCartButton.addActionListener(e -> {

            try {

                cart.addMedia(media);

                JOptionPane.showMessageDialog(
                        null,
                        "Added to cart!"
                );

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        null,
                        ex.getMessage(),
                        "Cart Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });

        container.add(addToCartButton);

        if (media instanceof Playable) {

            JButton playButton =
                    new JButton("Play");

            playButton.addActionListener(e -> {

                JOptionPane.showMessageDialog(
                        null,
                        media.toString(),
                        "Playing",
                        JOptionPane.INFORMATION_MESSAGE
                );
            });

            container.add(playButton);
        }

        add(Box.createVerticalStrut(10));
        add(title);
        add(cost);
        add(Box.createVerticalGlue());
        add(container);

        setBorder(
                BorderFactory.createLineBorder(
                        Color.BLACK
                )
        );
    }
}