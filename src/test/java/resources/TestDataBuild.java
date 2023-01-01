package resources;

import pojo.AddBook;

public class TestDataBuild {
	
	public AddBook addBookPayLoad(String id, String title,String description,String pageCount, String excerpt, String publishDate)
	{
		AddBook b= new AddBook();
		b.setId(id);
		b.setTitle(title);
		b.setDescription(description);
		b.setPageCount(pageCount);
		b.setExcerpt(excerpt);
		b.setPublishDate(publishDate);
		
		return b;
		
		
	}

}
