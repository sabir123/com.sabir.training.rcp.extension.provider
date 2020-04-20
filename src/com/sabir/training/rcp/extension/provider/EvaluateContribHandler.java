package com.sabir.training.rcp.extension.provider;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ISafeRunnable;

import org.eclipse.core.runtime.Platform;

public class EvaluateContribHandler extends AbstractHandler implements ISafeRunnable {

	private static String ISAYHELLO_ID = "com.sabir.training.extensionpoint.sayHello";
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		System.out.println("EvaluateContribHandler.execute()");
		
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(ISAYHELLO_ID);
		try {
			for(IConfigurationElement e :config) {
				
				final Object o = e.createExecutableExtension("class");
				if(o instanceof ISayHello) {
					executeExtension(o);
				}}}
			
			catch(CoreException ex) {
				System.out.println(ex.getMessage());
			}
		
		
		return null;
	}

	@Override
	public void run() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	private void executeExtension(Object o) {
		((ISayHello)o).sayHello();
	}


}
