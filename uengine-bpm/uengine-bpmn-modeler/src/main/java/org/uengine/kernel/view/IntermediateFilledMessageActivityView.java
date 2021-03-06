package org.uengine.kernel.view;

import org.uengine.kernel.IntermediateFilledMessageActivity;
import org.uengine.modeling.IElement;
import org.uengine.modeling.Symbol;

public class IntermediateFilledMessageActivityView extends EventActivityView {

	public final static String SHAPE_ID = "OG.shape.bpmn.E_Intermediate_MessageFill";
	
	public IntermediateFilledMessageActivityView(){
		
	}
	
	public IntermediateFilledMessageActivityView(IElement element){
		super(element);
	}
	@Override
	public Symbol createSymbol() {
		Symbol symbol = new Symbol();
		symbol.setName("메시지 중간");
		symbol.setShapeId(SHAPE_ID);
		symbol.setHeight(30);
		symbol.setWidth(30);
		symbol.setElementClassName(IntermediateFilledMessageActivity.class.getName());
		symbol.setShapeType("GEOM");
		
		return symbol;
	}
	
}
