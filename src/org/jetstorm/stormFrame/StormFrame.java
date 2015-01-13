package org.jetstorm.stormFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

/**
 * The StormFrame class is a frameless window class that can be used as a base
 * to create your own custom application windows.
 * 
 * @since 23.Oct.2011
 * @author Sherman
 * @version 1.6
 * 
 */

public abstract class StormFrame extends JFrame implements ActionListener
{
	final private byte[] WINDOWBARICON = { -119, 80, 78, 71, 13, 10, 26, 10, 0,
			0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 1, 0, 0, 0, 37, 8, 2, 0, 0, 0,
			12, 74, 20, -2, 0, 0, 0, -117, 73, 68, 65, 84, 120, -38, 99, -32,
			-97, 119, -117, 65, 96, -50, 117, 6, -63, 25, 23, 24, -124, -89,
			-100, 102, 16, -18, 63, -54, 32, -42, 125, -112, 65, -94, 125, 47,
			-125, 120, -45, 54, 6, -119, -38, -115, 12, 82, 85, 107, 25, -92,
			-53, 86, 48, -56, 22, 46, 100, -112, -51, -99, -61, -96, -112, 61,
			-125, 65, 41, 109, 10, -125, 82, 66, 47, -125, 114, 76, 7, -125,
			114, 88, 35, -125, 106, 112, 45, -125, -102, 127, 57, -125, -70,
			119, 49, -125, -70, 123, 46, -125, -74, 75, 54, -125, -82, 67, 26,
			-125, -82, 117, 60, -125, -82, 105, 36, -125, -98, 81, 40, 16, 7,
			51, -24, -61, -80, 97, 48, -125, -82, 65, 32, 10, -42, -47, 15, 96,
			-48, 51, 12, 2, 0, 112, -60, 37, 53, 94, 69, 64, -116, 0, 0, 0, 0,
			73, 69, 78, 68, -82, 66, 96, -126 };
	final private byte[] WINDOWCLOSEICON = { -119, 80, 78, 71, 13, 10, 26, 10,
			0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 16, 0, 0, 0, 16, 8, 6, 0, 0,
			0, 31, -13, -1, 97, 0, 0, 0, -18, 73, 68, 65, 84, 120, -38, -83,
			-111, 61, 10, -124, 48, 16, -123, -125, -118, 32, -120, -118, 22,
			-126, 96, -95, 40, 8, -2, -128, -98, 100, -117, 61, -124, -73, -55,
			97, 114, -72, 20, 22, -77, -103, 33, -59, 36, -40, 40, 43, 124,
			-56, -68, -9, -14, -116, -119, 16, -1, 120, -10, 125, 63, -113,
			-29, -48, 6, 120, -128, -58, 117, 98, 93, -41, 104, -37, 54, 109,
			-128, 23, 104, -79, 44, 75, 52, -49, 51, -68, -123, 126, 97, -102,
			38, -16, -72, 12, -54, -45, -108, -43, -99, 44, 21, 12, -61, 0,
			-116, 107, 28, -57, -81, -43, -91, -43, 36, -50, -88, -93, -49,
			-13, 84, -48, 117, 29, 48, 20, 63, -32, -66, -17, 63, 124, 70, -97,
			-25, 73, 108, -37, 22, 60, -28, -35, 109, -95, -18, 103, -55, 104,
			-102, 6, 110, 112, -66, -116, -13, 93, -114, -52, -70, -82, -63,
			-29, 118, 7, -88, -5, 89, 50, -86, -86, 2, -122, 115, 6, 101, 89,
			58, 59, 65, -97, -25, 73, 44, -118, 2, 24, 87, -106, 101, 116, 11,
			121, -98, 75, -44, -16, -115, 51, -22, -24, -13, 60, 21, -92, 105,
			10, 30, -105, 65, 121, -102, -78, -70, -109, -91, -126, 36, 73,
			-32, 45, 84, 16, -57, -79, 54, -64, 11, 52, 21, -124, 97, 120, 6,
			65, -96, 13, -16, 0, -115, -21, 126, 63, -67, -15, -8, -122, -14,
			-17, -118, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126 };
	final private byte[] WINDOWMAXIMIZEBUTTON = { -119, 80, 78, 71, 13, 10, 26,
			10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 16, 0, 0, 0, 16, 8, 6, 0,
			0, 0, 31, -13, -1, 97, 0, 0, 0, -62, 73, 68, 65, 84, 120, -38, -83,
			-111, 93, 7, -123, 64, 16, -122, 87, 37, -46, 94, 68, 18, 81, -118,
			-67, 40, 125, 80, -65, -86, -1, 127, 51, -105, -17, -103, -122, 88,
			-50, -74, 78, -21, 44, -113, 101, -26, -103, -41, 126, 40, -11,
			-113, -75, -17, -5, 121, 28, 7, 49, 120, 1, 93, 115, 106, 93, -41,
			100, -37, 54, 98, 16, 0, -87, 101, 89, -110, 121, -98, 17, -118,
			92, 97, 28, 71, -72, -104, -90, -87, -65, -6, -68, -101, 39, 71, 2,
			-116, 49, 112, 97, -65, -109, -41, 25, -122, 1, 46, -20, 0, -81,
			-45, -74, 45, 110, -70, -82, -21, 125, 63, -58, 125, 99, -5, 82,
			108, -102, 6, 55, -65, 124, -5, -105, 95, -41, 53, 110, -86, -86,
			-14, -98, -128, -5, -58, -10, -91, 88, -106, 37, 92, -40, -125, 94,
			-89, 40, 10, -72, -80, 3, -68, -114, -42, 26, 46, -14, 60, -105,
			-21, -16, 110, -98, 28, 9, -56, -78, 12, -95, 72, 64, -102, -90,
			-60, 32, 0, -110, -128, 56, -114, -49, 40, -118, -120, -63, 11,
			-24, -102, -5, 0, -55, -113, -20, 22, -62, 68, 101, -80, 0, 0, 0,
			0, 73, 69, 78, 68, -82, 66, 96, -126 };
	final private byte[] WINDOWMINIMIZEBUTTON = { -119, 80, 78, 71, 13, 10, 26,
			10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 16, 0, 0, 0, 16, 8, 6, 0,
			0, 0, 31, -13, -1, 97, 0, 0, 0, -90, 73, 68, 65, 84, 120, -38, -83,
			-47, -63, 10, -124, 32, 16, 6, 96, -55, 8, 2, 15, 65, -120, 16, 20,
			27, 120, 8, 82, -63, -98, -86, -9, -65, -52, -15, 95, 27, 8, -126,
			32, -74, 97, -123, -17, -30, -52, -4, 40, -93, -44, 63, 78, -50,
			121, -33, -74, -115, 10, -68, 64, -57, -100, -118, 49, -42, 41, 37,
			42, 32, 64, 42, -124, 80, -81, -21, 10, 41, -2, -62, -78, 44, -112,
			-30, 0, -17, 61, -92, 56, 96, -98, 103, 72, 113, -64, 56, -114, 56,
			77, -45, -12, 121, -38, 88, -87, -5, 107, 63, 95, 14, -61, -128,
			-45, 47, 107, -65, -11, 59, -25, 112, -78, -42, 62, -66, -96, -44,
			-3, -75, -97, 47, -5, -66, -121, 20, 7, 116, 93, 7, 41, 14, 48,
			-58, 64, -118, 3, -38, -74, -123, 20, 7, 52, 77, 67, 5, 4, -120, 3,
			-76, -42, 123, 85, 85, 84, -32, 5, 58, -26, -66, -36, 77, 1, -49,
			23, -70, 35, 106, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126 };

	private enum ButtonProperties
	{
		close("X", "Close this application."), minimize("_",
				"Minimize this application."), maximize("+",
				"Maximize or Restore this application.");
		private String toolTip;

		ButtonProperties(String l, String t)
		{
			toolTip = t;
		}

		public Dimension getSize()
		{
			return new Dimension(75, 25);
		}

		public String getToolTip()
		{
			return toolTip;
		}
	}

	private ImageIcon closeIcon;
	private ImageIcon minimizeIcon;
	private ImageIcon maximizeIcon;
	private ImageIcon windowBarIcon;
	private final String compSize = "normal";
	private final String sizeVari = "JComponent.sizeVariant";
	private final String controlSize = "small";
	private static final long serialVersionUID = 5716317891219903801L;
	private Point initialClick;
	private JPanel container = new JPanel();
	private JPanel content = new JPanel();
	private JPanel windowBar = new JPanel()
	{
		private static final long serialVersionUID = -1129806829398501419L;

		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			if (windowBarIcon != null) {
				g.drawImage(windowBarIcon.getImage(), 0, 0, getWidth(),
						getHeight(), this);
			}
		}
	};
	private JPanel buttonBar = new JPanel()
	{
		private static final long serialVersionUID = 8159858553220181942L;

		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			if (windowBarIcon != null) {
				g.drawImage(windowBarIcon.getImage(), 0, 0, getWidth(),
						getHeight(), this);
			}
		}
	};
	private JButton minimize = new JButton();
	private JButton maximize = new JButton();
	private JButton close = new JButton();
	private JLabel windowTitle = new JLabel();
	private GridBagLayout gridbag = new GridBagLayout();
	private GridLayout grid = new GridLayout(1, 3);
	private boolean resizable;

	public StormFrame(final String t, final boolean resizable,
			final boolean alwaysOnTop)
	{
		configureElements();
		buildDefaultElements();
		addActionListeners();
		installMouseListeners();
		setTitle(t);
		setName(t);
		windowTitle.setText(t);
		windowTitle.setFont(new Font(windowTitle.getFont().getFontName(),
				Font.BOLD, windowTitle.getFont().getSize()));
		windowTitle.setForeground(Color.white);
		windowTitle.setToolTipText(t);
		this.resizable = resizable;
		setResizable(resizable);
		setUndecorated(true);
		setAlwaysOnTop(alwaysOnTop);
		setUp();
		setLocationRelativeTo(null);
	}

	private void setUp()
	{
		loadIcons();
		container.setBorder(new CurvedBorder(1));
		content.setBorder(BorderFactory.createTitledBorder(null, " ",
				TitledBorder.BELOW_TOP, TitledBorder.BELOW_TOP));
		add(container);
		setContentPane(container);
		container.setLayout(new BorderLayout());
		setProperties();
		windowBar.setLayout(new BorderLayout());
		setCompSize(windowBar, new Dimension(windowBar.getWidth(), 37));
		windowBar.add(windowTitle, BorderLayout.WEST);
		grid.setHgap(4);
		buttonBar.add(minimize);
		if (resizable)
			buttonBar.add(maximize);
		buttonBar.add(close);
		windowBar.add(buttonBar, BorderLayout.EAST);
		container.add(windowBar, BorderLayout.NORTH);
		container.add(content, BorderLayout.CENTER);
		content.setLayout(gridbag);
		minimize.setFocusable(false);
		maximize.setFocusable(false);
		close.setFocusable(false);
		int mini = minimize.getPreferredSize().width;
		int maxi = maximize.getPreferredSize().width;
		int clos = close.getPreferredSize().width;
		int wind = getPreferredSize().width;
		int widt = windowTitle.getPreferredSize().width;
		int heig = windowTitle.getPreferredSize().height;
		int neww = widt + (wind - (mini + clos + widt)) - 44;
		if (resizable)
			neww -= maxi;
		Dimension windowTitleSize = new Dimension(neww, heig);
		//setCompSize(windowTitle, windowTitleSize);
		windowTitle.setHorizontalAlignment(SwingConstants.CENTER);
		refreshWindow();
	}

	public void actionPerformed(ActionEvent ae)
	{
		Object source = ae.getSource();
		if (source == close) {
			closeApp();
		} else if (source == minimize) {
			setExtendedState(Frame.ICONIFIED);
		} else if (source == maximize) {
			switchWindowState();
		} else {
			actionHandler(source);
		}
	}

	public abstract void actionHandler(Object source);

	public abstract void addActionListeners();

	public abstract void buildDefaultElements();

	public abstract void configureElements();

	public void refreshWindow()
	{
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
		}
		SwingUtilities.updateComponentTreeUI(this);
		pack();
	}

	public void setWindowTitle(String title)
	{
		setTitle(title);
		windowTitle.setText(title);
		pack();
	}

	public void setResizable(boolean resizable)
	{
		this.resizable = resizable;
	}

	private void closeApp()
	{
		setVisible(false);
		System.exit(-1);
	}

	private void installMouseListeners()
	{
		MouseMotionAdapter mouseMotionAdapter = new MouseMotionAdapter()
		{
			public void mouseDragged(MouseEvent e)
			{
				// get location of Window
				final int thisX = getLocation().x;
				final int thisY = getLocation().y;
				// Determine how much the mouse moved since the initial click
				final int xMoved = e.getX() - initialClick.x;
				final int yMoved = e.getY() - initialClick.y;
				final int[] positions = getPosition();
				if (!resizable) {
					// Move window to this position
					final int X = thisX + xMoved;
					final int Y = thisY + yMoved;
					setLocation(X, Y);
				} else {
					if (thisX <= positions[0] || thisY <= positions[1]) {
						// Attempt to resize if the initial point is 2 pixels
						// from one of the borders.
						// Move window to this position
						final int X = thisX + xMoved;
						final int Y = thisY + yMoved;
						setBounds(X, Y, (positions[2] - positions[0])
								- (positions[0] + xMoved),
								(positions[3] - positions[1])
										- (positions[1] + yMoved));
					} else if (thisX >= positions[2] || thisY >= positions[3]) {
						// Attempt to resize if the initial point is 2 pixels
						// from one of the borders.
						// Move window to this position
						setBounds(positions[0], positions[1],
								(positions[2] - positions[0]) + xMoved,
								(positions[3] - positions[1]) + yMoved);
					}
				}

			}
		};
		MouseAdapter mouseAdapter = new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
				initialClick = e.getPoint();
				getComponentAt(initialClick);
				Object comp = e.getSource();
				if (comp == windowBar || comp == windowTitle
						|| comp == buttonBar) {
					if (e.getClickCount() == 2) {
						switchWindowState();
					}
				}
			}
		};
		// Get point of initial mouse click
		// addMouseListener(mouseAdapter);
		// Move window when mouse is dragged
		windowBar.addMouseMotionListener(mouseMotionAdapter);
		buttonBar.addMouseMotionListener(mouseMotionAdapter);
		windowTitle.addMouseMotionListener(mouseMotionAdapter);
		windowBar.addMouseListener(mouseAdapter);
		windowTitle.addMouseListener(mouseAdapter);
		buttonBar.addMouseListener(mouseAdapter);
	}

	private void loadIcons()
	{
		java.net.URL imageURL = StormFrame.class
				.getResource("icon/windowBar.png");
		if (imageURL != null) {
			windowBarIcon = new ImageIcon(imageURL);
		} else {
			InputStream in = new ByteArrayInputStream(WINDOWBARICON);
			try {
				BufferedImage image = ImageIO.read(in);
				windowBarIcon = new ImageIcon(image);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		java.net.URL imageURL1 = StormFrame.class
				.getResource("icon/close16.png");
		if (imageURL1 != null) {
			closeIcon = new ImageIcon(imageURL1);
		} else {
			InputStream in = new ByteArrayInputStream(WINDOWCLOSEICON);
			try {
				BufferedImage image = ImageIO.read(in);
				closeIcon = new ImageIcon(image);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		close.setText("");
		close.setIcon(closeIcon);
		java.net.URL imageURL2 = StormFrame.class
				.getResource("icon/minimize16.png");
		if (imageURL2 != null) {
			minimizeIcon = new ImageIcon(imageURL2);
		} else {
			InputStream in = new ByteArrayInputStream(WINDOWMINIMIZEBUTTON);
			try {
				BufferedImage image = ImageIO.read(in);
				minimizeIcon = new ImageIcon(image);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		minimize.setText("");
		minimize.setIcon(minimizeIcon);
		if (resizable) {
			java.net.URL imageURL3 = StormFrame.class
					.getResource("icon/maximize16.png");
			if (imageURL3 != null) {
				maximizeIcon = new ImageIcon(imageURL3);
			} else {
				InputStream in = new ByteArrayInputStream(WINDOWMAXIMIZEBUTTON);
				try {
					BufferedImage image = ImageIO.read(in);
					maximizeIcon = new ImageIcon(image);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			maximize.setText("");
			maximize.setIcon(maximizeIcon);
		}
		this.pack();
	}

	private void setProperties()
	{
		int insx = close.getInsets().top;
		Dimension windowButtonSize = new Dimension(insx * 2 + 17, insx * 2 + 17);
		close.putClientProperty(sizeVari, controlSize);
		close.setToolTipText(ButtonProperties.close.getToolTip());
		close.setPreferredSize(ButtonProperties.close.getSize());
		close.addActionListener(this);
		minimize.putClientProperty(sizeVari, controlSize);
		minimize.setToolTipText(ButtonProperties.minimize.getToolTip());
		minimize.setPreferredSize(ButtonProperties.minimize.getSize());
		minimize.addActionListener(this);
		setCompSize(close, windowButtonSize);
		setCompSize(minimize, windowButtonSize);
		if (resizable) {
			maximize.putClientProperty(sizeVari, controlSize);
			maximize.setToolTipText(ButtonProperties.maximize.getToolTip());
			maximize.setPreferredSize(ButtonProperties.maximize.getSize());
			maximize.addActionListener(this);
			setCompSize(maximize, windowButtonSize);
		}
	}

	private void setCompSize(final JComponent obj, final Dimension size)
	{
		obj.setPreferredSize(size);
		obj.setMinimumSize(size);
		obj.setMaximumSize(size);
	}

	/**
	 * This method is the builder method that creates the components.
	 * 
	 * @param obj - represents the component that it is setting up
	 * @param gx - Grid Position X
	 * @param gy - Grid Position Y
	 * @param gw - Grid spaces taken X
	 * @param gh - Grid spaces taken Y
	 * @param wx - Grid weight X
	 * @param wy - Grid weight Y
	 * @param fill - 0: Both - 1: None - 2: Horizontal - 3: Vertical
	 * @param alignment - 0: Center - 1: North - 2: NE - 3: East - 4: SE - 5:
	 *            South - 6: SW - 7: West - 8: NW
	 **/
	protected void buildElement(final JComponent obj,
			final StormConstraints constraint)
	{
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = constraint.getGx();
		gbc.gridy = constraint.getGy();
		gbc.gridwidth = constraint.getGw();
		gbc.gridheight = constraint.getGh();
		gbc.weightx = constraint.getWx();
		gbc.weightx = constraint.getWy();
		gbc.fill = constraint.getFill();
		gbc.anchor = constraint.getAlignment();
		gridbag.setConstraints(obj, gbc);
		obj.putClientProperty(sizeVari, compSize);
		content.add(obj);
	}

	private int[] getPosition()
	{
		int[] positions = { getX(), getY(),
				getX() + getWidth(), getY() + getHeight() };
		return positions;
	}

	protected void switchWindowState()
	{
		if (resizable) {
			if (getExtendedState() == Frame.NORMAL) {
				setExtendedState(Frame.MAXIMIZED_BOTH);
			} else {
				setExtendedState(Frame.NORMAL);
				pack();
			}
		}
	}

	public void setContainerTitle(String title)
	{
		if (title != null) {
			content.setBorder(BorderFactory.createTitledBorder(null, title,
					TitledBorder.BELOW_TOP, TitledBorder.BELOW_TOP));
		} else {
			content.setBorder(BorderFactory.createTitledBorder(null, " ",
					TitledBorder.BELOW_TOP, TitledBorder.BELOW_TOP));
		}
	}

	public void setIconImage(Image image)
	{
		super.setIconImage(image);
		int imageW = image.getWidth(null);
		int imageH = image.getHeight(null);
		int width = imageW >= imageH ? 32 : (int) (imageW*32.0/imageH);
		int height = imageH >= imageH ? 32 : (int) (imageH*32.0/imageW);
		windowTitle.setIcon(new ImageIcon(image.getScaledInstance(width, height, Image.SCALE_SMOOTH)));
	}
}
