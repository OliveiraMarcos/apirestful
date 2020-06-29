package br.com.rh.apirest;


import br.com.rh.apirest.application.dtos.Identity;
import br.com.rh.apirest.application.dtos.SectorDto;
import br.com.rh.apirest.domain.entities.BaseEntity;
import br.com.rh.apirest.domain.entities.Sector;
import com.google.common.reflect.TypeToken;
import java.lang.reflect.Type;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ApirestApplicationTests {

    @Autowired
    private ModelMapper modelMapper;
    
    @Test
    void contextLoads() {
    }
    
    @Test
    public void test_auto_mapper()throws Exception {
        var dto = new SectorDto().setName("Teste");
        Sector entity = GetX(dto);
        assertThat(entity.getName()).isSameAs(dto.getName());
    }
    
    private <X extends Sector, Y extends Identity> X GetX(Y value){
        Type type = new TypeToken<X>(getClass()){}.getType();
        
        X result = this.modelMapper.map(value, type);
        return result;
    }
    
    
    
}
