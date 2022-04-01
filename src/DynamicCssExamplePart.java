 

import javax.inject.Inject;

import javax.annotation.PostConstruct;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.RowLayoutFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class DynamicCssExamplePart {
	
	private static final String IMAGES_HELP_PNG = "images/help.png";
	private static final String IMAGES_INFO_PNG = "images/info.png";
	private static final String IMAGES_FAVOURITE_PNG = "images/favourite.png";
	
	private LocalResourceManager localResourceManager;
	
	@Inject
	public DynamicCssExamplePart() {
		localResourceManager = new LocalResourceManager(JFaceResources.getResources());
	}
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		parent.setLayout(GridLayoutFactory.swtDefaults().margins(24,24).spacing(24,24).numColumns(4).create());

		RowLayoutFactory verticalRowLayout = RowLayoutFactory.swtDefaults().type(SWT.VERTICAL);
		GridDataFactory layoutDataFactory = GridDataFactory.swtDefaults().align(SWT.LEFT, SWT.TOP);
		
		// RADIO
		Group radioButtonGroup = new Group(parent, SWT.NONE);
		radioButtonGroup.setText("Button RADIO");
		radioButtonGroup.setLayout(verticalRowLayout.create());
		radioButtonGroup.setLayoutData(layoutDataFactory.create());
		
		Button radio1 = new Button(radioButtonGroup, SWT.RADIO);
		radio1.setText("one");
		radio1.setImage(getImage(IMAGES_INFO_PNG));
		radio1.setSelection(true);
		
		Button radio2 = new Button(radioButtonGroup, SWT.RADIO);
		radio2.setText("two");
		radio2.setImage(localResourceManager.createImage(
				ImageDescriptor.createFromFile(DynamicCssExamplePart.class, IMAGES_HELP_PNG)));
		
		Button radio3 = new Button(radioButtonGroup, SWT.RADIO);
		radio3.setImage(localResourceManager.createImage(
				ImageDescriptor.createFromFile(DynamicCssExamplePart.class, IMAGES_FAVOURITE_PNG)));
		
		Button radio4 = new Button(radioButtonGroup, SWT.RADIO);
		radio4.setText("four");
		radio4.setEnabled(false);
		
		
		// TOGGLE
		Group toggleButtonGroup = new Group(parent, SWT.NONE);
		toggleButtonGroup.setLayout(verticalRowLayout.create());
		toggleButtonGroup.setText("Button TOGGLE");
		toggleButtonGroup.setLayoutData(layoutDataFactory.create());

		Button toggle1 = new Button(toggleButtonGroup, SWT.TOGGLE);
		toggle1.setText("one");
		toggle1.setImage(getImage(IMAGES_INFO_PNG));
		toggle1.setSelection(true);
		
		Button toggle2 = new Button(toggleButtonGroup, SWT.TOGGLE);
		toggle2.setText("two");
		Button toggle3 = new Button(toggleButtonGroup, SWT.TOGGLE);
		toggle3.setText("three");
		Button toggle4 = new Button(toggleButtonGroup, SWT.TOGGLE);
		toggle4.setText("four");
		toggle4.setEnabled(false);
		
		
		// CHECK
		Group checkButtonGroup = new Group(parent, SWT.NONE);
		checkButtonGroup.setLayout(verticalRowLayout.create());
		checkButtonGroup.setText("Button CHECK");
		checkButtonGroup.setLayoutData(layoutDataFactory.create());

		Button check1 = new Button(checkButtonGroup, SWT.CHECK);
		check1.setText("one");
		
		Button check2 = new Button(checkButtonGroup, SWT.CHECK);
		check2.setText("two");
		check2.setImage(getImage(IMAGES_FAVOURITE_PNG));
		check2.setSelection(true);
		
		Button check3 = new Button(checkButtonGroup, SWT.CHECK);
		check3.setEnabled(false);
		check3.setImage(getImage(IMAGES_HELP_PNG));
		
		Button check4 = new Button(checkButtonGroup, SWT.CHECK);
		check4.setText("four");
		check4.setEnabled(false);
		
		Button check5 = new Button(checkButtonGroup, SWT.CHECK);
		check5.setText("five");
		
		
		// PUSH
		Group pushButtonGroup = new Group(parent, SWT.NONE);
		pushButtonGroup.setLayout(verticalRowLayout.create());
		pushButtonGroup.setText("Button PUSH");
		pushButtonGroup.setLayoutData(layoutDataFactory.create());
		
		Button push1 = new Button(pushButtonGroup, SWT.PUSH);
		push1.setText("enable/disable toolbar");

		
		Button push2 = new Button(pushButtonGroup, SWT.PUSH);
		push2.setText("disable self");
		push2.setImage(getImage(IMAGES_HELP_PNG));
		push2.addListener(SWT.Selection, event -> {
			push2.setEnabled(false);
		});
		
		Button push3 = new Button(pushButtonGroup, SWT.PUSH);
		push3.setText("three");
		push3.setEnabled(false);
		
		
		Button push4 = new Button(pushButtonGroup, SWT.PUSH);
		push4.setText("disable all");
		push4.addListener(SWT.Selection, event -> {
			boolean enabled = false;
			radio1.setEnabled(enabled);
			radio2.setEnabled(enabled);
			radio3.setEnabled(enabled);
			radio4.setEnabled(enabled);

			toggle1.setEnabled(enabled);
			toggle2.setEnabled(enabled);
			toggle3.setEnabled(enabled);
			toggle4.setEnabled(enabled);
			
			check1.setEnabled(enabled);
			check2.setEnabled(enabled);
			check3.setEnabled(enabled);
			check4.setEnabled(enabled);
			check5.setEnabled(enabled);

			push1.setEnabled(enabled);
			push2.setEnabled(enabled);
			push3.setEnabled(enabled);
		});
		
		Button push5 = new Button(pushButtonGroup, SWT.PUSH);
		push5.setText("enable all");
		push5.addListener(SWT.Selection, event -> {
			boolean enabled = true;
			radio1.setEnabled(enabled);
			radio2.setEnabled(enabled);
			radio3.setEnabled(enabled);
			radio4.setEnabled(enabled);

			toggle1.setEnabled(enabled);
			toggle2.setEnabled(enabled);
			toggle3.setEnabled(enabled);
			toggle4.setEnabled(enabled);
			
			check1.setEnabled(enabled);
			check2.setEnabled(enabled);
			check3.setEnabled(enabled);
			check4.setEnabled(enabled);
			check5.setEnabled(enabled);

			push1.setEnabled(enabled);
			push2.setEnabled(enabled);
			push3.setEnabled(enabled);
		});
		
		
		// Group for toolbar			
		Group toolbarGroup = new Group(parent, SWT.NONE);
		toolbarGroup.setLayout(verticalRowLayout.create());
		toolbarGroup.setLayoutData(GridDataFactory.swtDefaults().span(3, 1).align(SWT.LEFT, SWT.TOP).create());
		toolbarGroup.setText("ToolBar");
		
		ToolBar toolBar = new ToolBar(toolbarGroup, SWT.FLAT | SWT.RIGHT);

		ToolItem toolItemPush = new ToolItem(toolBar, SWT.PUSH);
		toolItemPush.setText("Text Button");
		toolItemPush.setToolTipText("Text Button Tooltip");
		toolItemPush.addListener(SWT.Selection, e -> System.out.println("push"));
		
		ToolItem toolItemCheck = new ToolItem(toolBar, SWT.CHECK);
		toolItemCheck.setText("Check Button");
		toolItemCheck.setToolTipText("Check Button Tooltip");
		toolItemCheck.addListener(SWT.Selection, e -> System.out.println("check"));
		
		ToolItem toolItemRadio = new ToolItem(toolBar, SWT.CHECK);
		toolItemRadio.setText("Radio Button");
		toolItemRadio.setToolTipText("Radio Button Tooltip");
		toolItemRadio.addListener(SWT.Selection, e -> System.out.println("radio"));
		
		ToolItem toolItemIconPush = new ToolItem(toolBar, SWT.PUSH);
		toolItemIconPush.setImage(getImage(IMAGES_INFO_PNG));
		toolItemIconPush.addListener(SWT.Selection, e -> System.out.println("blip icon push"));

		ToolItem toolItemIconCheck= new ToolItem(toolBar, SWT.CHECK);
		toolItemIconCheck.setImage(getImage(IMAGES_FAVOURITE_PNG));
		toolItemIconCheck.addListener(SWT.Selection, e -> toolItemIconPush.setEnabled(!toolItemIconPush.getEnabled()));
		
		ToolItem toolItemIconRadio = new ToolItem(toolBar, SWT.RADIO);
		toolItemIconRadio.setImage(getImage(IMAGES_HELP_PNG));
		toolItemIconRadio.addListener(SWT.Selection, e -> System.out.println("blip icon radio"));
				
		push1.addListener(SWT.Selection, e -> toolBar.setEnabled(!toolBar.getEnabled()));

		
		// Group for Tree
		Group treeGroup = new Group(parent, SWT.NONE);
		treeGroup.setLayout(verticalRowLayout.create());
		treeGroup.setLayoutData(layoutDataFactory.create());
		treeGroup.setText("Tree");
		
		TreeViewer treeViewer = new TreeViewer(treeGroup, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		treeViewer.setLabelProvider(new ColumnLabelProvider());
		treeViewer.setContentProvider(new ExampleContentProvider());
		
		
	}

	private Image getImage(String image) {
		return localResourceManager.createImage(
				ImageDescriptor.createFromFile(DynamicCssExamplePart.class, image));
	}
	
	
		
}