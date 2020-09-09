package guru.springframework.brewery.web.mappers;

import guru.springframework.brewery.domain.Beer;
import guru.springframework.brewery.web.model.BeerDto;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-09T15:10:34+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 14.0.1 (N/A)"
)
@Component
public class BeerMapperImpl implements BeerMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public BeerDto beerToBeerDto(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerDto beerDto = new BeerDto();

        beerDto.setId( beer.getId() );
        if ( beer.getVersion() != null ) {
            beerDto.setVersion( beer.getVersion().intValue() );
        }
        beerDto.setCreatedDate( dateMapper.asOffsetDateTime( beer.getCreatedDate() ) );
        beerDto.setLastModifiedDate( dateMapper.asOffsetDateTime( beer.getLastModifiedDate() ) );
        beerDto.setBeerName( beer.getBeerName() );
        beerDto.setBeerStyle( beer.getBeerStyle() );
        beerDto.setUpc( beer.getUpc() );
        beerDto.setPrice( beer.getPrice() );

        return beerDto;
    }

    @Override
    public Beer beerDtoToBeer(BeerDto beerDto) {
        if ( beerDto == null ) {
            return null;
        }

        Beer beer = new Beer();

        beer.setId( beerDto.getId() );
        if ( beerDto.getVersion() != null ) {
            beer.setVersion( beerDto.getVersion().longValue() );
        }
        beer.setCreatedDate( dateMapper.asTimestamp( beerDto.getCreatedDate() ) );
        beer.setLastModifiedDate( dateMapper.asTimestamp( beerDto.getLastModifiedDate() ) );
        beer.setBeerName( beerDto.getBeerName() );
        beer.setBeerStyle( beerDto.getBeerStyle() );
        beer.setUpc( beerDto.getUpc() );
        beer.setPrice( beerDto.getPrice() );

        return beer;
    }
}
