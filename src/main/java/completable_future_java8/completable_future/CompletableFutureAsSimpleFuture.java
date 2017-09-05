package completable_future_java8.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import junit.framework.Assert;

public class CompletableFutureAsSimpleFuture {

	public static void main(String[] args) {
		
		CompletableFutureAsSimpleFuture futureAsSimpleFuture = new CompletableFutureAsSimpleFuture();
		try {
			Future<String> future = futureAsSimpleFuture.calculcateAsync("Antesh");
			String result = future.get();
			Assert.assertEquals("Hello, Antesh", result);
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	private Future<String> calculcateAsync(String name) throws InterruptedException
	{
		CompletableFuture<String> completableFuture = new CompletableFuture<>();
		
		Executors.newCachedThreadPool().submit(() -> {
			Thread.sleep(20000);
			completableFuture.complete("Hello, " + name);
			return null;
		});
		
		return completableFuture;
	}
}
