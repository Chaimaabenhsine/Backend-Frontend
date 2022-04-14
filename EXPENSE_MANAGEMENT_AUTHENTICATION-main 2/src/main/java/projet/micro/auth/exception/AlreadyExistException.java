package projet.micro.auth.exception;

public class AlreadyExistException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public AlreadyExistException (String message)
	{
		super(message);
	}

}