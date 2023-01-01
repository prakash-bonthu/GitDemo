package resources;
//enum is a special class in java which has collection of constants or methods
public enum APIResources {
	
	CreateBook("/api/v1/Books"),
	GetBook("/api/v1/Books/{id}"),
	UpdateBook("/api/v1/Books/{id}"),
	DeleteBook("/api/v1/Books/{id}");
	private String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}

}
