package org.uengine.kernel;

import org.metaworks.ContextAware;
import org.metaworks.MetaworksContext;
import org.metaworks.Remover;
import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.Name;
import org.metaworks.annotation.Order;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.ModalWindow;
import org.uengine.contexts.TextContext;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.IElement;
import org.uengine.util.UEngineUtil;

@Face(ejsPath="genericfaces/ActivityFace.ejs", options={"fieldOrder"},values={"name,description"})
public class Pool implements IElement, java.io.Serializable, ContextAware{

	transient MetaworksContext metaworksContext;
		public MetaworksContext getMetaworksContext() {
			return metaworksContext;
		}
		public void setMetaworksContext(MetaworksContext metaworksContext) {
			this.metaworksContext = metaworksContext;
		}
	
	String name;
	@Face(displayName="$activityName")
	@Order(1)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
		
	TextContext description = TextContext.createInstance();
	@Name
	@Face(displayName="$activityDisplayName")
	@Order(2)
		public String getDescription() {
			return description.getText();
		}
		public void setDescription(TextContext string) {
			description = string;
		}
		public void setDescription(String string) {
			description.setText(string);
		}
		
	PoolResolutionContext poolResolutionContext;
	@Face(displayName="웹서비스 선택")
	@Order(3)
		public PoolResolutionContext getPoolResolutionContext() {
			if( poolResolutionContext == null ){
				String poolResolutionContexts = GlobalContext.getPropertyString("poolresolutioncontexts", null);
				if( poolResolutionContexts != null ){
					try{
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
			return poolResolutionContext;
		}
		public void setPoolResolutionContext(PoolResolutionContext poolResolutionContext) {
			this.poolResolutionContext = poolResolutionContext;
		}
		

	transient String currentEditorId;
	@Hidden
		public String getCurrentEditorId() {
			return currentEditorId;
		}
		public void setCurrentEditorId(String currentEditorId) {
			this.currentEditorId = currentEditorId;
		}	
	public Pool(){
		setMetaworksContext(new MetaworksContext());
		this.setDescription("");
	}
	
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] apply(){
		
		if ( this.getDescription() == null || "".equals(this.getDescription())){
			this.setDescription(this.getName());
		}
		return null;
	}

	
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] cancel(){
		ModalWindow modalWindow = new ModalWindow();
		return new Object[]{new Remover(modalWindow , true)};
		
	}
	
	ElementView elementView;

	public ElementView createView(){
		ElementView elementView = (ElementView) UEngineUtil.getComponentByEscalation(getClass(), "view");
		elementView.setElement(this);

		return elementView;
	}

	public ElementView getElementView() {
		return this.elementView;
	}
	public void setElementView(ElementView elementView) {
		this.elementView = elementView;
	}
	
	public void createDocument() {
		// TODO Auto-generated method stub
	}
}
